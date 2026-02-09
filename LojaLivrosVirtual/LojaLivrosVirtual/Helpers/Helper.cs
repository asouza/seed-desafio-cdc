namespace LojaLivrosVirtual.Helpers
{
    public static class Helper
    {
        public static string RemoveAccents(this string input)
        {
            return input.ToLowerInvariant().Trim();
        }
    }
}