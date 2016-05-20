import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import clase.IstoricProteine;

@RunWith(Categories.class)
@IncludeCategory(GoodTestCategory.class)
@ExcludeCategory(BadCategory.class)
@Suite.SuiteClasses({IstoricProteineTests.class, TesteCuParametrii.class})

public class GoodTestsSuite {

}
