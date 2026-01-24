using LojaLivrosVirtual.DTOs.Author;
using LojaLivrosVirtual.Entities;
using Microsoft.AspNetCore.Mvc;

namespace LojaLivrosVirtual.Controllers;

[Route("[controller]")]
[ApiController]
public class AuthorController : ControllerBase
{
    // GET: api/<AuthorController>
    [HttpGet]
    public IEnumerable<string> Get()
    {
        return new string[] { "value1", "value2" };
    }

    [HttpPost]
    public IActionResult Post([FromBody] AuthorRequest request)
    {
        var author = new Author(request.Name, request.Email, request.Description);
        return Ok(author);
    }
}
