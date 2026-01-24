namespace LojaLivrosVirtual.Entities
{
    public class Author
    {   
        public int Id { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }
        public string Description { get; set; }
        public DateTime CreatedAt { get; set; } = DateTime.Now;
        public bool DeletedDate { get; set; }

        public Author(string name, string email, string description)
        {
            if (string.IsNullOrWhiteSpace(name))
                throw new ArgumentException("Name cannot be null or empty.", nameof(name));

            if (string.IsNullOrWhiteSpace(email))
                throw new ArgumentException("Email cannot be null or empty.", nameof(name));

            if (string.IsNullOrWhiteSpace(description))
                throw new ArgumentException("Description cannot be null or empty.", nameof(name));

            if (description.Length > 400)
            {
                throw new ArgumentException("Description cannot have more then 400 caracteres", nameof(name));
            }

            Name = name;
            Email = email;
            Description = description;
        }
    }
}
