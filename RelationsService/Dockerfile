FROM node:16.14-alpine 
# Create app directory
WORKDIR /server

COPY package*.json ./
RUN npm install
RUN npm install pm2 -g

COPY . .

EXPOSE 3000
CMD ["pm2-runtime" ,"index.js"]
