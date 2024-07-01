const request = require('supertest');
const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const app = require('../server');
const Service = require('../models/Service');
const User = require('../models/User');

describe('Services API', () => {
  beforeAll(async () => {
    mongoose.connect(process.env.MONGO_URI);
  });

  afterAll(async () => {
    await mongoose.connection.close();
  });

  it('should create a new service', async () => {
    const admin = new User({
      username: 'admin',
      email: 'admin@example.com',
      password: await bcrypt.hash('Password123', 10),
      role: 'admin'
    });
    await admin.save();

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
    expect(response.body).toHaveProperty('_id');
    expect(response.body.name).toBe('Consultoria Digital');
  });

  it('should get all services', async () => {
    const response = await request(app).get('/api/services');
    expect(response.statusCode).toBe(200);
    expect(response.body.length).toBeGreaterThan(0);
  });
});
