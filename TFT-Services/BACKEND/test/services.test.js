// test/services.test.js
const request = require('supertest');
const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const app = require('../server');
const Service = require('../models/Service');
const User = require('../models/User');

let server;

beforeAll(async () => {
    await mongoose.connect(process.env.MONGO_URI);
    server = app.listen(5001); // Usa un puerto diferente para pruebas
});

afterAll(async () => {
    await mongoose.connection.close();
    server.close();
});

describe('Services API', () => {
    it('should create a new service', async () => {
        const admin = new User({
            username: 'admin',
            email: 'admin@example.com',
            password: await bcrypt.hash('Password123', 10),
            role: 'admin'
        });
        await admin.save();

        const token = jwt.sign({ id: admin._id, role: 'admin' }, process.env.SECRET_KEY, { expiresIn: '1h' });

        const response = await request(server)
            .post('/api/services')
            .set('Authorization', `Bearer ${token}`)
            .send({
                name: 'Pack Marketing Digital. 6 meses.',
                description: 'Estrategia, planificación y hoja de ruta en procesos de comunicación, marketing y publicidad en redes sociales y medios digitales; para empresas y autónomos.',
                category: 'Servicios Digitales',
                price: 500
            });

        if (response.statusCode !== 201) {
            console.error('Error response body:', response.body);
        }

        expect(response.statusCode).toBe(201);
        expect(response.body).toHaveProperty('_id');
        expect(response.body.name).toBe('Pack Marketing Digital. 6 meses.');
    });

    it('should get all services', async () => {
        const response = await request(server).get('/api/services');
        expect(response.statusCode).toBe(200);
        expect(response.body.length).toBeGreaterThan(0);
    });
});