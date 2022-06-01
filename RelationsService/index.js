const express = require('express');
const app = express();
app.use(express.json())

const PORT = process.env.PORT || 3000;
const eurekaHelper = require('./eureka-helper');
const neo4j = require('neo4j-driver')

const driver = neo4j.driver(process.env.neoURL, neo4j.auth.basic(process.env.neoUser,process.env.neoPw))
const session = driver.session()
app.listen(PORT, () => {
  console.log("relations-service on 3000");
})
app.get('/', (req, res) => {
 res.json("I am relations-service")
})
app.post('/relate', async(req,res) => {
  const result = await session.run("MATCH (a:Person), (b:Person) WHERE a.name = $name AND b.name = $name2 CREATE (a)-[r:RELTYPE]->(b) RETURN type(r)",
  { 
    name: req.body.name,
    name2: req.body.name2
  })
  res.json("Done")
})
app.post('/createNode',  async(req, res) => {
const result = await session.run(
  'CREATE (a:Person {name: $name}) RETURN a',
  { name: req.body.name }
)
res.json("Done")
})
app.get('/relations',  async(req, res) => {
  const result = await session.run(
    'MATCH (a:Person)-[r]-(b:Person) RETURN a,r,b'
  )
  res.json(result)
  })

//
const { Kafka } = require('kafkajs')

const kafka = new Kafka({
  clientId: 'relations-service',
  brokers: ['kafka:9092']
})

const consumer = kafka.consumer({ groupId: 'EMR' })

const run = async () => {
  // Consuming
  await consumer.connect()
  await consumer.subscribe({ topic: 'patient-created', fromBeginning: true })
  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      const session = driver.session()
      const msg = JSON.parse(message.value.toString()) 
      if (msg.nationalIDRel){
      await session.run(
        'MERGE (a:Person {name: $name}) RETURN a',
        { name: msg.nationalIDRel }
      )
      await session.run(
        'MERGE (a:Person {name: $name}) RETURN a',
        { name: msg.nationalID }
      )
      await session.run("MATCH (a:Person), (b:Person) WHERE a.name = $name AND b.name = $name2 MERGE (a)-[r:RELTYPE]->(b) RETURN type(r)",
        { 
          name: msg.nationalID,
          name2: msg.nationalIDRel
        })
        session.close();
      }
    },
  })
}

run().catch(console.error)
//
eurekaHelper.registerWithEureka('relations-service', PORT);