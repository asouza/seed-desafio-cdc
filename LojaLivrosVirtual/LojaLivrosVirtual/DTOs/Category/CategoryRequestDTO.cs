using System.ComponentModel.DataAnnotations;

namespace LojaLivrosVirtual.DTOs.Category
{
    public class CategoryRequestDTO
    {
        [Required(ErrorMessage = "Name is required")]
        public string Name { get; set; }
    }
}
