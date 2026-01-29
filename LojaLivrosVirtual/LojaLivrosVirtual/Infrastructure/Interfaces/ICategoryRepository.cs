using LojaLivrosVirtual.Entities;

namespace LojaLivrosVirtual.Infrastructure.Interfaces
{
    public interface ICategoryRepository
    {
        Task CreateAsync(Category category);
    }
}