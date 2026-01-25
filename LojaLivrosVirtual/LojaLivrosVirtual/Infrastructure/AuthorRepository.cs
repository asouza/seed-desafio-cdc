using LojaLivrosVirtual.Context;
using LojaLivrosVirtual.Entities;
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
            _dbContext = dbContext;
        }

        public async Task CreateAsync(Author newAuthor) 
        {
            await _dbContext.AddAsync(newAuthor);
            await _dbContext.SaveChangesAsync();
        }
    }
}
