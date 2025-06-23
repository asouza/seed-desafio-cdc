import { ConflictError } from "../config/error.js";
import { AuthorRepository } from "../repositories/authorRepository.js";
import { Author, authorSchema } from "../schemas/authorSchema.js";

export class AuthorService {
  constructor(private authorRepository: AuthorRepository) { }

  createAuthor = async (author: Author): Promise<Author> => {
    await authorSchema.validateAsync(author);

    const existingAuthor = await this.authorRepository.findByEmail(author.email);
    if (existingAuthor) {
      throw new ConflictError(`Author already exists.`);
    }

    return await this.authorRepository.create(author);
  }
}
