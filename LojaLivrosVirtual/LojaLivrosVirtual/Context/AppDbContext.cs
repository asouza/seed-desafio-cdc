using LojaLivrosVirtual.Entities;
using Microsoft.EntityFrameworkCore;

namespace LojaLivrosVirtual.Context
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
        }

        public DbSet<Author> Authors { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Author>(entity =>
            {
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Id).HasColumnName("AuthorId");
                entity.Property(e => e.Name).IsRequired().HasMaxLength(200);
                entity.Property(e => e.Email).IsRequired().HasMaxLength(200);
                entity.Property(e => e.Description).HasMaxLength(400);
                entity.Property(e => e.CreateDate);
                entity.Property(e => e.DeletedDate);
            });
        }
    }
}
