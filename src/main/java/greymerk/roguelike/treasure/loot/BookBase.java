package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class BookBase implements IBook {

	private List<String> pages;
	private String author;
	private String title;

	public BookBase() {
		this.pages = new ArrayList<String>();
	}

	public BookBase(String author, String title) {
		this.pages = new ArrayList<String>();
		this.author = author;
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addPage(String page) {
		this.pages.add(page);
	}

	@Override
	public ItemStack get() {
		ItemStack book = new ItemStack(Items.WRITTEN_BOOK, 1);

		ListNBT nbtPages = new ListNBT();

		for (String page : this.pages) {
			ITextComponent text = new StringTextComponent(page);
			String json = ITextComponent.Serializer.toJson(text);
			StringNBT nbtPage = new StringNBT(json);
			nbtPages.add(nbtPage);
		}

		book.setTagInfo("pages", nbtPages);
		book.setTagInfo("author", new StringNBT(this.author == null ? "Anonymous" : this.author));
		book.setTagInfo("title", new StringNBT(this.title == null ? "Book" : this.title));

		return book;
	}
}
