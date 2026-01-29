using LojaLivrosVirtual.DTOs.Category;
using LojaLivrosVirtual.Entities;
using LojaLivrosVirtual.Infrastructure.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace LojaLivrosVirtual.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class CategoryController : ControllerBase
    {
        private readonly ICategoryRepository _categoryRepository;

        public CategoryController(ICategoryRepository categoryRepository)
        {
            _categoryRepository = categoryRepository;
        }

        [HttpPost("categories")]
        public async Task<IActionResult> CreateAsync([FromBody] CategoryRequestDTO request)
        {
            var category = new Category(request.Name);
            await _categoryRepository.CreateAsync(category);
            return Ok(category);

        }
    }
}
