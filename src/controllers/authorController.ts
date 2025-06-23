import { Request, Response } from 'express';
import { AuthorService } from '../services/authorService.js';

export class AuthorController {
  constructor(private authorService: AuthorService) { }

  postAuthor = async (req: Request, res: Response): Promise<void> => {
    try {
      const author = await this.authorService.createAuthor(req.body);
      res.status(201).json(author);
    } catch (error: any) {
      if (error.name === 'ValidationError') {
        res.status(400).json({ error: error.message });
      } else if (error.name === 'ConflictError') {
        res.status(409).json({ error: error.message });
      } else {
        res.status(500).json({ error: error.message || 'Internal Server Error' });
      }
    }
  }
}