import { Author, AuthorRequest } from '../schemas/authorSchema.js';
import { PrismaClient } from '@prisma/client';

export class AuthorRepository {
  constructor(private database: PrismaClient) { }

  create = async (author: AuthorRequest): Promise<Author> => {
    return await this.database.author.create({ data: author });
  }

  findByEmail = async (email: string): Promise<Author | null> => {
    return await this.database.author.findUnique({ where: { email } });
  }
}