const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const PORT = process.env.PORT || 5000;

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Conexión a MongoDB
mongoose.connect('mongodb://localhost:27017/tftservices')
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log(err));

// Rutas
const servicesRoutes = require('./routes/services');
const usersRoutes = require('./routes/users');
const bookingRoutes = require('./routes/bookings');
const adminRoutes = require('./routes/admin');

app.use('/api/services', servicesRoutes);
app.use('/api/users', usersRoutes);
app.use('/api/bookings', bookingRoutes);
app.use('/api/admin', adminRoutes);

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
