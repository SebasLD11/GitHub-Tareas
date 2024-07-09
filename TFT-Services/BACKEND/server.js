const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const bodyParser = require('body-parser');
const logger = require('./utils/logger');
require('dotenv').config();

const app = express();
const PORT = process.env.PORT || 5000;

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Conexión a MongoDB
mongoose.connect(process.env.MONGO_URI)
    .then(() => logger.info('MongoDB connected'))
    .catch(err => logger.error(`MongoDB connection error: ${err.message}`));

//Rutas
	const authRoutes = require('./routes/auth');
	const serviceRoutes = require('./routes/services');
	const bookingRoutes = require('./routes/bookings');
	const userRoutes = require('./routes/users');
	const adminRoutes = require('./routes/admin');

	app.use('/api/auth', authRoutes);
	app.use('/api/services', serviceRoutes);
	app.use('/api/bookings', bookingRoutes);
	app.use('/api/users', userRoutes);
	app.use('/api/admin', adminRoutes);

app.listen(PORT, () => {
	    logger.info(`Server is running on port ${PORT}`);
	});	
module.exports = app;