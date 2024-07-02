const mongoose = require('mongoose');
const logger = require('../utils/logger');

const connectDB = async () => {
    try {
        const conn = mongoose.connect(process.env.MONGO_URI);
        logger.info(`MongoDB connected: ${conn.connection.host}`);
    } catch (err) {
        logger.error(`Error: ${err.message}`);
        process.exit(1);
    }
};

module.exports = connectDB;
