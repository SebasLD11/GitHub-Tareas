const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const PORT = process.env.PORT || 5000;

// Cargar variables de entorno manualmente
const MONGO_URI = process.env.MONGO_URI || 'mongodb://localhost:27017/tftservices';
const SECRET_KEY = process.env.SECRET_KEY || 'your_secret_key';

// Verificar si las variables de entorno se cargaron correctamente
console.log('Mongo URI:', MONGO_URI);
console.log('Secret Key:', SECRET_KEY);

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Conexión a MongoDB
mongoose.connect(MONGO_URI)
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log('MongoDB connection error:', err));


// Rutas
const authRoutes = require('./routes/auth');
const serviceRoutes = require('./routes/services');
const bookingRoutes = require('./routes/bookings');
const userRoutes = require('./routes/users');

app.use('/api/auth', authRoutes);
app.use('/api/services', serviceRoutes);
app.use('/api/bookings', bookingRoutes);
app.use('/api/users', userRoutes);

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
