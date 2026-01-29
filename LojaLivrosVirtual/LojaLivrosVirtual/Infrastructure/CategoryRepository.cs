using LojaLivrosVirtual.Context;
using LojaLivrosVirtual.Entities;
using LojaLivrosVirtual.Infrastructure.Interfaces;

namespace LojaLivrosVirtual.Infrastructure
{
    public class CategoryRepository : ICategoryRepository
    {
        private readonly AppDbContext _context;

        public CategoryRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task CreateAsync(Category category)
        {
            await _context.Categories.AddAsync(category);
            await _context.SaveChangesAsync();
        }
    }
}
