const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const verifyRole = require('../middleware/role');
const Service = require('../models/Service');

// Crear servicio (solo administrador)
router.post('/', auth, verifyRole('admin'), async (req, res) => {
    const { name, description, category, price } = req.body;
    try {
        const service = new Service({ name, description, category, price});
        await service.save();
        res.status(201).json({ message: 'Service created successfully' });
    } catch (err) {
        res.status(500).json({ message: 'Error creating service', error: err.message });
    }
});

// Obtener todos los servicios
router.get('/', async (req, res) => {
    try {
        const services = await Service.find();
        res.json(services);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching services', error: err.message });
    }
});

module.exports = router;
