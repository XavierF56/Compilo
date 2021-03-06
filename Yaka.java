/* Generated By:JavaCC: Do not edit this line. Yaka.java */
public class Yaka implements YakaConstants {
        public static Declaration declaration = new Declaration();
        public static TabIdent tabIdent = new TabIdent();
        public static Expression expression = new Expression();
        public static String fichier;
        public static YVM yvm ;
        public static int ligne = 1;
        public static boolean finAppelFonction = false;


  public static void main(String args[]) {
    Yaka analyseur;
    java.io.InputStream input;

    if (args.length==1) {
      try {
        input = new java.io.FileInputStream("Yaka/"+args[args.length-1]+".yaka");
        fichier = args[args.length-1];
        yvm = new YVMasm("ASM/"+fichier + ".asm");
      } catch (java.io.FileNotFoundException e) {
        System.out.println("Fichier introuvable.");
        return;
      }
    } else if (args.length==0) {
      System.out.println("Lecture sur l'entree standard...");
      input = System.in;
    } else {
      System.out.println("Usage: java Gram [fichier]");
      return;
    }
    try {
      analyseur = new Yaka(input);
      analyseur.analyse();
    } catch (ParseException e) {
      String msg = e.getMessage();
      msg = msg.substring(0,msg.indexOf("\u005cn"));
      System.out.println("Erreur de syntaxe : "+msg);
    }
  }

/**************************************/
/********debut de la grammaire ********/
/**************************************/
  static final public void analyse() throws ParseException {
    jj_consume_token(PROGRAMME);
                yvm.entete();
    jj_consume_token(ident);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BOOLEEN:
      case ENTIER:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      declFonction();
    }
    jj_consume_token(PRINCIPAL);
                yvm.main();
    bloc();
    jj_consume_token(FPRINCIPAL);
    yvm.queue();
    jj_consume_token(FPROGRAMME);
  }

  static final public void bloc() throws ParseException {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONST:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      declConst();
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      declVar();
    }
               yvm.ouvreBloc(IdVar.getCompteur()*2);
    suiteInstr();
  }

/******************** Fonction *********************/
  static final public void declFonction() throws ParseException {
    type();
    jj_consume_token(FONCTION);
    jj_consume_token(ident);
        yvm.nomFonc(YakaTokenManager.identLu);
        declaration.ajoutIdentFonc(YakaTokenManager.identLu);
        expression.setFonction(tabIdent.chercheIdentGlob(YakaTokenManager.identLu));
    paramForms();
               tabIdent.setOffsets();
    bloc();
   yvm.fermeBloc(IdParam.getCompteur()*2);
  tabIdent.raz();
    jj_consume_token(FFONCTION);
  }

  static final public void paramForms() throws ParseException {
    jj_consume_token(52);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOOLEEN:
    case ENTIER:
      paramForm();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 53:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_4;
        }
        jj_consume_token(53);
        paramForm();
      }
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(54);
  }

  static final public void paramForm() throws ParseException {
    type();
    jj_consume_token(ident);
                  declaration.ajoutIdentParam(YakaTokenManager.identLu);
  }

  static final public void retourne() throws ParseException {
    jj_consume_token(RETOURNE);
    expression();
        expression.testRetourne();
        yvm.ireturn(IdParam.getCompteur()*2+4);
  }

/******************** Declaration *********************/
  static final public void declConst() throws ParseException {
    jj_consume_token(CONST);
    defConst();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 53:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_5;
      }
      jj_consume_token(53);
      defConst();
    }
    jj_consume_token(55);
  }

  static final public void defConst() throws ParseException {
    jj_consume_token(ident);
           declaration.setNom(YakaTokenManager.identLu);
    jj_consume_token(56);
    valConst();
                   declaration.ajoutIdentConst();
  }

  static final public void valConst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
    declaration.setValEntier(YakaTokenManager.entierLu);
      break;
    case ident:
      jj_consume_token(ident);
   declaration.setValIdent(YakaTokenManager.identLu);
      break;
    case VRAI:
      jj_consume_token(VRAI);
   declaration.setValVRAI();
      break;
    case FAUX:
      jj_consume_token(FAUX);
  declaration.setValFAUX();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declVar() throws ParseException {
    jj_consume_token(VAR);
    type();
    jj_consume_token(ident);
   declaration.ajoutIdentVar(YakaTokenManager.identLu);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 53:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_6;
      }
      jj_consume_token(53);
      jj_consume_token(ident);
       declaration.ajoutIdentVar(YakaTokenManager.identLu);
    }
    jj_consume_token(55);
  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTIER:
      jj_consume_token(ENTIER);
    declaration.setTypeEntier();
      break;
    case BOOLEEN:
      jj_consume_token(BOOLEEN);
    declaration.setTypeBool();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
 * Syntaxe des instructions.
 */
  static final public void suiteInstr() throws ParseException {
    instruction();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_7;
      }
      jj_consume_token(55);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SI:
      case RETOURNE:
      case TANTQUE:
      case ECRIRE:
      case LIRE:
      case ALALIGNE:
      case ident:
        instruction();
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
    }
  }

  static final public void instruction() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ident:
      affectation();
      break;
    case LIRE:
      lecture();
      break;
    case ECRIRE:
    case ALALIGNE:
      ecriture();
      break;
    case TANTQUE:
      iteration();
      break;
    case SI:
      conditionnelle();
      break;
    case RETOURNE:
      retourne();
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void affectation() throws ParseException {
    jj_consume_token(ident);
                Ident id = tabIdent.chercheIdent(YakaTokenManager.identLu);
                id.setAffecte(true);
                expression.setTypeAffectation(id.getType());
                expression.setOffsetAffectation(id.getOffset());
    jj_consume_token(56);
    expression();
                          expression.clotureExpression();
  }

  static final public void lecture() throws ParseException {
    jj_consume_token(LIRE);
    jj_consume_token(52);
    jj_consume_token(ident);
    jj_consume_token(54);
                ((IdVar)tabIdent.chercheIdent(YakaTokenManager.identLu)).setAffecte(true);
                yvm.lireEnt(((IdVar)tabIdent.chercheIdent(YakaTokenManager.identLu)).getOffset());
  }

  static final public void ecriture() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ECRIRE:
      jj_consume_token(ECRIRE);
      jj_consume_token(52);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VRAI:
      case FAUX:
      case NON:
      case entier:
      case ident:
      case 52:
      case 63:
        expression();
                                   expression.clotureExpression();
        break;
      case chaine:
        jj_consume_token(chaine);
                               yvm.ecrireChaine(YakaTokenManager.chaineLue);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(54);
      break;
    case ALALIGNE:
      jj_consume_token(ALALIGNE);
   yvm.aLaLigne();
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/********************* Expression ************************/
  static final public void expression() throws ParseException {
    simpleExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
    case 57:
    case 58:
    case 59:
    case 60:
    case 61:
      opRel();
      simpleExpr();
   expression.controleType(); yvm.opRel();
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }

  }

  static final public void simpleExpr() throws ParseException {
    terme();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OU:
      case 62:
      case 63:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_8;
      }
      opAdd();
      terme();
    expression.controleType(); yvm.opAdd();
    }
  }

  static final public void terme() throws ParseException {
    facteur();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ET:
      case 64:
      case 65:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_9;
      }
      opMul();
      facteur();
   expression.controleType(); yvm.opMul();
    }
  }

  static final public void facteur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
    case 52:
      primaire();
      break;
    case NON:
    case 63:
      opNeg();
      primaire();
                         expression.controleTypeNEG(); yvm.opNeg();
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void primaire() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
      valeur();
      break;
    case 52:
      jj_consume_token(52);
      expression();
      jj_consume_token(54);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void argumentsFonction() throws ParseException {
    jj_consume_token(52);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case NON:
    case entier:
    case ident:
    case 52:
    case 63:
      expression();
                     expression.testParam();
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 53:
          ;
          break;
        default:
          jj_la1[19] = jj_gen;
          break label_10;
        }
        jj_consume_token(53);
        expression();
                                                                expression.testParam();
      }
      break;
    default:
      jj_la1[20] = jj_gen;
      ;
    }
    jj_consume_token(54);
  }

  static final public void valeur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
             expression.empiler(ENTIER); yvm.iconst(YakaTokenManager.entierLu);
      break;
    case ident:
      jj_consume_token(ident);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 52:
  yvm.reserveRetour();expression.setFonctionPile(tabIdent.chercheIdentGlob(YakaTokenManager.identLu));
        argumentsFonction();
  expression.clotureFonction();finAppelFonction = true;
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
        if(finAppelFonction) {
                finAppelFonction = false;
                Yaka.yvm.call(expression.getNomFonction());
        } else {
                expression.empiler(tabIdent.chercheIdent(YakaTokenManager.identLu).getType());
                tabIdent.chercheIdent(YakaTokenManager.identLu).yvm();
        }
      break;
    case VRAI:
      jj_consume_token(VRAI);
            expression.empiler(VRAI); yvm.iconst(-1);
      break;
    case FAUX:
      jj_consume_token(FAUX);
            expression.empiler(FAUX); yvm.iconst(0);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opRel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
      jj_consume_token(56);
         expression.empiler(EGAL);yvm.push(EGAL);
      break;
    case 57:
      jj_consume_token(57);
         expression.empiler(DIFFERENT);yvm.push(DIFFERENT);
      break;
    case 58:
      jj_consume_token(58);
         expression.empiler(INF);yvm.push(INF);
      break;
    case 59:
      jj_consume_token(59);
         expression.empiler(INFOUEG);yvm.push(INFOUEG);
      break;
    case 60:
      jj_consume_token(60);
         expression.empiler(SUP); yvm.push(SUP);
      break;
    case 61:
      jj_consume_token(61);
         expression.empiler(SUPOUEG); yvm.push(SUPOUEG);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opAdd() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 62:
      jj_consume_token(62);
          expression.empiler(PLUS); yvm.push(PLUS);
      break;
    case 63:
      jj_consume_token(63);
          expression.empiler(MOINS); yvm.push(MOINS);
      break;
    case OU:
      jj_consume_token(OU);
          expression.empiler(OU); yvm.push(OU);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opMul() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 64:
      jj_consume_token(64);
                  expression.empiler(MULT); yvm.push(MULT);
      break;
    case 65:
      jj_consume_token(65);
          expression.empiler(DIV); yvm.push(DIV);
      break;
    case ET:
      jj_consume_token(ET);
          expression.empiler(ET); yvm.push(ET);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opNeg() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 63:
      jj_consume_token(63);
          expression.empiler(NEG); yvm.push(NEG);
      break;
    case NON:
      jj_consume_token(NON);
          expression.empiler(NON); yvm.push(NON);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*********** Conditionnelle et Iteration ****************/
  static final public void iteration() throws ParseException {
    jj_consume_token(TANTQUE);
                   yvm.tantQue();
    expression();
                                                 yvm.faire();expression.clotureIterationCondition();
    jj_consume_token(FAIRE);
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SI:
      case RETOURNE:
      case TANTQUE:
      case ECRIRE:
      case LIRE:
      case ALALIGNE:
      case ident:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_11;
      }
      suiteInstr();
    }
                                 yvm.goTo(); yvm.fait();
    jj_consume_token(FAIT);
  }

  static final public void conditionnelle() throws ParseException {
    jj_consume_token(SI);
    expression();
                           yvm.alors(); expression.clotureIterationCondition();
    jj_consume_token(ALORS);
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SI:
      case RETOURNE:
      case TANTQUE:
      case ECRIRE:
      case LIRE:
      case ALALIGNE:
      case ident:
        ;
        break;
      default:
        jj_la1[28] = jj_gen;
        break label_12;
      }
      suiteInstr();
    }
                                  yvm.goToCond();yvm.sinon();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINON:
      jj_consume_token(SINON);
      label_13:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SI:
        case RETOURNE:
        case TANTQUE:
        case ECRIRE:
        case LIRE:
        case ALALIGNE:
        case ident:
          ;
          break;
        default:
          jj_la1[29] = jj_gen;
          break label_13;
        }
        suiteInstr();
      }
      break;
    default:
      jj_la1[30] = jj_gen;
      ;
    }
                                     yvm.fsi();
    jj_consume_token(FSI);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public YakaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[31];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8100,0x80000,0x200,0x0,0x8100,0x0,0x120000,0x0,0x8100,0x0,0x52000,0x52000,0x1120000,0x0,0x0,0x400000,0x800000,0x1120000,0x120000,0x0,0x1120000,0x0,0x120000,0x0,0x400000,0x800000,0x1000000,0x52000,0x52000,0x52000,0x800,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x200000,0x0,0x200000,0x50000,0x200000,0x0,0x800000,0x40007,0x40007,0x801d0000,0x5,0x3f000000,0xc0000000,0x0,0x80150000,0x150000,0x200000,0x80150000,0x100000,0x50000,0x3f000000,0xc0000000,0x0,0x80000000,0x40007,0x40007,0x40007,0x0,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Yaka(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Yaka(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Yaka(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Yaka(YakaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(YakaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[66];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 31; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 66; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
