const request = require('supertest');
const mongoose = require('mongoose');
const app = require('../server');
const Booking = require('../models/Booking');
const Service = require('../models/Service');
const User = require('../models/User');

describe('Bookings API', () => {
  beforeAll(async () => {
    await mongoose.connect(process.env.MONGO_URI);
  });

  beforeEach(async () => {
      await Booking.deleteMany({});
  });
  it('should create a new booking', async () => {
    const user = new User({
      username: 'testuser',
      email: 'testuser@example.com',
      password: await bcrypt.hash('Password123', 10)
    });
    await user.save();

    const service = new Service({
      name: 'Consultoria Digital',
      description: 'Estrategia, planificación y hoja de ruta en procesos de digitalización para empresas y autónomos.',
      category: 'Servicios Digitales',
      price: 100
    });
    await service.save();

    const token = jwt.sign({ id: user._id, role: 'user' }, process.env.SECRET_KEY, { expiresIn: '1h' });

    const response = await request(app)
      .post('/api/bookings')
      .set('Authorization', `Bearer ${token}`)
      .send({
        service: service._id,
        date: new Date(),
        timeSlot: '10:00-11:00'
      });

    expect(response.statusCode).toBe(201);
    expect(response.body).toHaveProperty('message', 'Booking created successfully');
    expect(response.body.booking).toHaveProperty('_id');
  });

  it('should get all bookings', async () => {
    const admin = new User({
      username: 'admin',
      email: 'admin@example.com',
      password: await bcrypt.hash('Password123', 10),
      role: 'admin'
    });
    await admin.save();

    const token = jwt.sign({ id: admin._id, role: 'admin' }, process.env.SECRET_KEY, { expiresIn: '1h' });

    const response = await request(app)
      .get('/api/bookings')
      .set('Authorization', `Bearer ${token}`);

    expect(response.statusCode).toBe(200);
    expect(response.body.length).toBeGreaterThan(0);
  });
 afterAll(async () => {
     await mongoose.connection.close();
   });
});