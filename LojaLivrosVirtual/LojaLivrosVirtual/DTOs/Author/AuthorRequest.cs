using System.ComponentModel.DataAnnotations;

namespace LojaLivrosVirtual.DTOs.Author
{
    public class AuthorRequest
    {
        [Required(ErrorMessage = "Name is required.")]
        public string Name { get; set; }

        [Required(ErrorMessage = "Email is required.")]
        [EmailAddress(ErrorMessage = "Invalid email address.")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Description is required.")]
        [MaxLength(400, ErrorMessage = "Description cannot exceed 400 characters.")]
        public string Description { get; set; }
    }
}
