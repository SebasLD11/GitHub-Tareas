const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const verifyRole = require('../middleware/role');
const serviceController = require('../controllers/serviceController');

// Crear servicio (solo administrador)
router.post('/services', auth, verifyRole('admin'), serviceController.createService);

// Obtener todos los servicios
router.get('/', serviceController.getAllServices);

//Actualizar Servicio (solo admin)
router.put('/:id', auth, verifyRole('admin'), serviceController.updateService);

//Eliminar Servicio(solo admin)
router.delete('/:id', auth, verifyRole('admin'), serviceController.deleteService);

module.exports = router;
