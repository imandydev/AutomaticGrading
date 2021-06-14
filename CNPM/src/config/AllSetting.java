package config;

public class AllSetting {
//	<-------------------------- View ----------------------->
//	********************** WIDTH - HEGITH *******************
//	LoginAndAnswerView
	public static final int widthLAR = Config.readFileConfigInt("width_LAR_View");
	public static final int heightLAR = Config.readFileConfigInt("height_LAR_View");
//	HomeView
	public static final int widthHomeView= Config.readFileConfigInt("width_Home_View");
	public static final int heightHomeView = Config.readFileConfigInt("height_Home_View");
//	ManagerTableView
	public static final int widthMTView= Config.readFileConfigInt("width_MT_View");
	public static final int heightMTView = Config.readFileConfigInt("height_MT_View");
//	AddTableView
	public static final int widthATView= Config.readFileConfigInt("width_AT_View");
	public static final int heightATView = Config.readFileConfigInt("height_AT_View");
//	DetailTableView
	public static final int widthDTView= Config.readFileConfigInt("width_DT_View");
	public static final int heightDTView = Config.readFileConfigInt("height_DT_View");
//	ManagerCodeView
	public static final int widthMCView= Config.readFileConfigInt("width_MC_View");
	public static final int heightMCView = Config.readFileConfigInt("height_MC_View");
//	ListMarkView
	public static final int widthLMView= Config.readFileConfigInt("width_LM_View");
	public static final int heightLMView = Config.readFileConfigInt("height_LM_View");
//	AddCodeAndAnswerView
//	width, height
	public static final int widthACASView= Config.readFileConfigInt("width_A_C_A_A_View");
	public static final int heightACASView = Config.readFileConfigInt("height_A_C_A_A_View");
//	text label
	public static final String codeLb = Config.readFileConfigStr("code_LB");
//	font-family
	public static final String fontFamilyAddCode = Config.readFileConfigStr("font_familyAC");
//	width height button
	
//	********************** WIDTH - HEGITH Minus Cancel Back Save*******************
	public static final int widthMinus= Config.readFileConfigInt("width_minus");
	public static final int heightMinus = Config.readFileConfigInt("height_minus");
	public static final int widthCancel= Config.readFileConfigInt("width_cancel");
	public static final int heightCancel = Config.readFileConfigInt("height_cancel");
	public static final int widthBack= Config.readFileConfigInt("width_back");
	public static final int heightBack = Config.readFileConfigInt("height_back");
	public static final int widthSave= Config.readFileConfigInt("width_save");
	public static final int heightSave = Config.readFileConfigInt("height_save");
//	opencv
	public static final String direcOpenCV = Config.readFileConfigStr("dir_opencv");
}
