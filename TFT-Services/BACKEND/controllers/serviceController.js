// controllers/serviceController.js
const Service = require('../models/Service');

exports.createService = async (req, res) => {
    const { name, description, category, price } = req.body;
    try {
        const service = new Service({ name, description, category, price });
        await service.save();
        res.status(201).json({ message: 'Service created successfully', service });
    } catch (err) {
        res.status(500).json({ message: 'Error creating service', error: err.message });
    }
};

//Ver todos los servicios
exports.getAllServices = async (req, res) => {
    try {
        const services = await Service.find();
        res.json(services);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching services', error: err.message });
    }
};

//Actualizar servicios
exports.updateService = async (req, res) => {
	 const { id } = req.params;
	    const { name, description, category, price } = req.body;
	    try {
	        const service = await Service.findByIdAndUpdate(id, { name, description, category, price }, { new: true });
	        res.json(service);
	    } catch (err) {
	        res.status(500).json({ message: 'Error updating service', error: err.message });
	    }
	};

//Eliminar Servicio (solo administrdor)
exports.deleteService = async (req, res) => {
	const { id } = req.params;
	    try {
	        await Service.findByIdAndDelete(id);
	        res.json({ message: 'Service deleted successfully' });
	    } catch (err) {
	        res.status(500).json({ message: 'Error deleting service', error: err.message });
	    }
	};

