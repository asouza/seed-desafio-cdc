import { Request, Response } from "express";

export class ConflictError extends Error {
  constructor(message: string) {
    super(message);
    this.name = 'ConflictError';
  }
}

export const errorHandler = (err: Error, res: Response) => {
  if (err.name === 'ConflictError') {
    return res.status(409).json({ error: err.message });
  } else if (err.name === 'ValidationError') {
    return res.status(400).json({ error: err.message });
  } else {
    return res.status(500).json({ error: err.message || 'Internal Server Error' });
  }
}