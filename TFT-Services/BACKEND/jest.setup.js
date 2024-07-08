const mongoose = require('mongoose');
const app = require('./server');
const logger = require('./utils/logger');

beforeAll(async () => {
    await mongoose.connect(process.env.MONGO_URI);
});

afterAll(async () => {
    await mongoose.connection.close();
});
