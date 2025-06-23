import { Request, Response } from 'express';
import { AuthorService } from '../services/authorService.js';
import { errorHandler } from '../config/error.js';

export class AuthorController {
  constructor(private authorService: AuthorService) { }

  postAuthor = async (req: Request, res: Response): Promise<void> => {
    try {
      const author = await this.authorService.createAuthor(req.body);
      res.status(201).json(author);
    } catch (error: any) {
      errorHandler(error, res);
    }
  }
}