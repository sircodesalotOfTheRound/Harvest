package com.hive.harvest.parse.expressions;

import com.hive.harvest.exceptions.HQLException;
import com.hive.harvest.graph.HQLNoReturnVisitor;
import com.hive.harvest.parse.lexer.HQLLexer;
import com.hive.harvest.parse.tokens.HQLIdentifierToken;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sircodesalot on 15/4/2.
 */
public abstract class HQLKeywordExpression extends HQLExpression {
  private static final Set<String> keywords = generateKeywordSet();

  public static final String SELECT = "SELECT";
  public static final String FROM = "FROM";
  public static final String WHERE = "WHERE";

  private final HQLIdentifierToken token;

  public HQLKeywordExpression(HQLExpression parent, HQLLexer lexer) {
    super(parent, lexer);

    this.token = readToken(lexer);
  }

  private HQLIdentifierToken readToken(HQLLexer lexer) {
    if (!isKeyword(lexer)) {
      throw new HQLException("Keyword expressions must be keywords");
    }

    return (HQLIdentifierToken)lexer.current();
  }

  public static boolean isKeyword(HQLLexer lexer) {
    return isKeyword(lexer.current().toString());
  }

  public static boolean isKeyword(String identifier) {
    return keywords.contains(identifier.toUpperCase());
  }

  private static Set<String> generateKeywordSet() {
    Set<String> keywords = new HashSet<String>();
    keywords.add(SELECT);
    keywords.add(FROM);
    keywords.add(WHERE);

    return keywords;
  }
}
