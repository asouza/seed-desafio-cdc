import express from 'express';
import { AuthorController } from '../controllers/authorController.js';
import { AuthorService } from '../services/authorService.js';
import { AuthorRepository } from '../repositories/authorRepository.js';
import { prismaClient } from '../config/prismaClient.js';

const authorRepository = new AuthorRepository(prismaClient);
const authorService = new AuthorService(authorRepository);
const authorController = new AuthorController(authorService);

const router = express.Router();

router.post('/', authorController.postAuthor);

export default router;