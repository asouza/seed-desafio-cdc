import Joi from "joi";

export interface Author {
  id: number;
  createdAt: Date;
  name: string;
  email: string;
  description: string;
}

export interface AuthorRequest {
  name: string;
  email: string;
  description: string;
}

export const authorSchema = Joi.object({
  name: Joi.string().required(),
  email: Joi.string().email().lowercase().required(),
  description: Joi.string().required().max(400),
}).required(); 