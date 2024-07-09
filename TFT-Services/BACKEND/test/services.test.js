const request = require('supertest');
const mongoose = require('mongoose');
const bcrypt = require('bcryptjs'); // Asegúrate de usar 'bcryptjs' si es la biblioteca que tienes instalada
const jwt = require('jsonwebtoken');
const app = require('../server.js');
const Service = require('../models/Service');
const User = require('../models/User');

describe('Services API', () => {
    let server;

    beforeAll(async () => {
        await mongoose.connect(process.env.MONGO_URI);
        server = app.listen(5001); // Usa un puerto diferente para pruebas
    });

    beforeEach(async () => {
        // Limpiar colecciones antes de cada prueba
        await User.deleteMany({});
        await Service.deleteMany({});
        
        // Crear un usuario admin para las pruebas
        const admin = new User({
            username: 'admin',
            email: 'admin@example.com',
            password: await bcrypt.hash('Password123', 10),
            role: 'admin'
        });
        await admin.save();
    });
	 it('should create a new service', async () => {
	        const admin = await User.findOne({ username: 'admin' });
	        const token = jwt.sign({ id: admin._id, role: 'admin' }, process.env.SECRET_KEY, { expiresIn: '1h' });

	        const response = await request(app)
	            .post('/api/services')
	            .set('Authorization', `Bearer ${token}`)
	            .send({
	                name: 'Consultoria Digital',
	                description: 'Estrategia, planificación y hoja de ruta en procesos de digitalización para empresas y autónomos.',
	                category: 'Servicios Digitales',
	                price: 100
	            });

	        expect(response.statusCode).toBe(201);
	        expect(response.body.service).toHaveProperty('_id');
	        expect(response.body.service.name).toBe('Consultoria Digital');
	    });

	    it('should get all services', async () => {
	        // Crear un servicio para la prueba
	        const service = new Service({
	            name: 'Consultoria Digital',
	            description: 'Estrategia, planificación y hoja de ruta en procesos de digitalización para empresas y autónomos.',
	            category: 'Servicios Digitales',
	            price: 100
	        });
	        await service.save();

	        const response = await request(app).get('/api/services');
	        expect(response.statusCode).toBe(200);
	        expect(response.body.length).toBeGreaterThan(0);
	    });

	    afterAll(async () => {
	        await mongoose.connection.close();
	        server.close();
	    });
	});