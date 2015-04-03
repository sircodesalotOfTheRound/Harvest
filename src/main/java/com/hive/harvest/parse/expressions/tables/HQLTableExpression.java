package com.hive.harvest.parse.expressions.tables;

import com.hive.harvest.parse.expressions.HQLExpression;
import com.hive.harvest.parse.expressions.backtracking.HQLNamedTableExpressionBacktrackRule;
import com.hive.harvest.parse.expressions.backtracking.interfaces.BacktrackRuleSet;
import com.hive.harvest.parse.lexer.HQLLexer;

/**
 * Created by sircodesalot on 15/4/3.
 */
public abstract class HQLTableExpression extends HQLExpression {
  private static final BacktrackRuleSet<HQLTableExpression> rules = new BacktrackRuleSet<HQLTableExpression>()
    .add(new HQLNamedTableExpressionBacktrackRule());

  public HQLTableExpression(HQLExpression parent, HQLLexer lexer) {
    super(parent, lexer);
  }

  public static boolean canParse(HQLExpression parent, HQLLexer lexer) {
    return rules.canParse(parent, lexer);
  }

  public static HQLTableExpression read(HQLExpression parent, HQLLexer lexer) {
    return rules.read(parent, lexer);
  }
}