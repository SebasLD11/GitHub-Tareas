const express = require('express');
const router = express.Router();
const Service = require('../models/service');
const auth = require('../middleware/auth');
const verifyRole = require('../middleware/role');

// Crear servicio (solo administrador)
router.post('/', auth, verifyRole('admin'), async (req, res) => {
    const { name, description, category, price, imageUrl } = req.body;
    try {
        const service = new Service({ name, description, category, price, imageUrl });
        await service.save();
        res.status(201).json({ message: 'Service created successfully' });
    } catch (err) {
        res.status(500).json({ message: 'Error creating service' });
    }
});

// Obtener todos los servicios
router.get('/', async (req, res) => {
    try {
        const services = await Service.find();
        res.json(services);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching services' });
    }
});

module.exports = router;
