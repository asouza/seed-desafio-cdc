using LojaLivrosVirtual.Entities;

namespace LojaLivrosVirtual.Infrastructure.Interfaces
{
    public interface IAuthorRepository
    {
        Task CreateAsync(Author newAuthor);
    }
}
