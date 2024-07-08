// test/auth.test.js
const request = require('supertest');
const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const app = require('../server');
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

beforeEach(async () => {
    await User.deleteMany({});
});

describe('Auth API', () => {
    it('should register a new user', async () => {
        const response = await request(server)
            .post('/api/auth/register')
            .send({
                username: 'testuser',
                email: 'testuser@example.com',
                password: 'Password123'
            });

        expect(response.statusCode).toBe(201);
        expect(response.body).toHaveProperty('token');
    });

    it('should login an existing user', async () => {
        const user = new User({
            username: 'testuser',
            email: 'testuser@example.com',
            password: await bcrypt.hash('Password123', 10)
        });
        await user.save();

        const response = await request(server)
            .post('/api/auth/login')
            .send({
                email: 'testuser@example.com',
                password: 'Password123'
            });

        expect(response.statusCode).toBe(200);
        expect(response.body).toHaveProperty('token');
    });
});
