using LojaLivrosVirtual.Context;
using LojaLivrosVirtual.Entities;
using LojaLivrosVirtual.Helpers;
using LojaLivrosVirtual.Infrastructure.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace LojaLivrosVirtual.Infrastructure
{
    public class AuthorRepository : IAuthorRepository
    {
        private readonly AppDbContext _dbContext;

        public AuthorRepository(AppDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task CreateAsync(Author newAuthor) 
        {
            if (await CheckIfEmailExists(newAuthor.Email))
                throw new Exception("Email já cadastrado.");

            await _dbContext.AddAsync(newAuthor);
            await _dbContext.SaveChangesAsync();
        }

        public async Task<bool> CheckIfEmailExists(string email)
        {
            return await _dbContext.Authors
                    .AnyAsync(a => a.NormalizedEmail == email.RemoveAccents());
        }

    }
}
