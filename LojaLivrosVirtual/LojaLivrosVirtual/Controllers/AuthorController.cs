using LojaLivrosVirtual.DTOs.Author;
using LojaLivrosVirtual.Entities;
using LojaLivrosVirtual.Infrastructure.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace LojaLivrosVirtual.Controllers;

[Route("[controller]")]
[ApiController]
public class AuthorController : ControllerBase
{
    private readonly IAuthorRepository _authorRepository;

    public AuthorController(IAuthorRepository authorRepository)
    {
        _authorRepository = authorRepository;
    }

    [HttpGet]
    public IEnumerable<string> Get()
    {
        return new string[] { "value1", "value2" };
    }

    [HttpPost]
    public async Task<IActionResult> Post([FromBody] AuthorRequestDTO request)
    {
        var author = new Author(request.Name, request.Email, request.Description);


        await _authorRepository.CreateAsync(author);

        return Ok(author);
    }
}
