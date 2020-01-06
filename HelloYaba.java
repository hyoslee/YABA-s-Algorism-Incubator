package com.yaba.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;
import com.yaba.demo.mapper.YabaMapper;
import com.yaba.demo.vo.ELS;

@RestController
public class HelloYaba {
	@Autowired YabaMapper yabaMapper ;

	public String[] GTA1 = {};
	public String[] GTA2 = {};
	
	public String[] eArr= {"054090", "255440", "052260", "263810", "182360", "027830",  "002810",  "123700",  "263750",  "005880",  "089010",  "004020",  "017000",  "112610",  "082920",  "096770",  "041910",  "006620",  "001750",  "097780",  "033500", "005830", "005290", "014130", "014530", "024800", "088790"};
//	public String[] eArr= {"003670", "192650", "192080", "316140", "298690", "267850", "306200", "293480", "010400", "293940", "091810", "286940", "298040", "298050", "298020", "298000", "088260", "018250", "068270", "284740", "285130", "282330", "092780", "272450", "281820", "282690", "055490", "271980", "268280", "251270", "079440", "267270", "267260", "267250", "264900", "145720", "111110", "234080", "241590", "229640", "204210", "249420", "248170", "016740", "123890", "034830", "195870", "070960", "101530", "004440", "152330", "226320", "075580", "214330", "089590", "079550", "002690", "095570", "214320", "214420", "214390", "210980", "145210", "213500", "210540", "112610", "018260", "192400", "133820", "027410", "192820", "185750", "183190", "180640", "181710", "168490", "013870", "037560", "163560", "161890", "161000", "159650", "155900", "014710", "153360", "144620", "152550", "079980", "145270", "007070", "145990", "039130", "078520", "023000", "031430", "140910", "047810", "071840", "138490", "139130", "053210", "019440", "138040", "020150", "011210", "136490", "134380", "134790", "082740", "126560", "130660", "900140", "030790", "057050", "002150", "128820", "122900", "128940", "105840", "033920", "103130", "102460", "123690", "123700", "120030", "120110", "119650", "071320", "115390", "012160", "118000", "052690", "114090", "034730", "032560", "000080", "082640", "047400", "093240", "039490", "033660", "028100", "071970", "108670", "109070", "107590", "026940", "104700", "103590", "103140", "017180", "100220", "102260", "102280", "101140", "101060", "100840", "100250", "099340", "099350", "085310", "051600", "093230", "044450", "094280", "033270", "092200", "097230", "096760", "096770", "096300", "001780", "095720", "094800", "090370", "093050", "044380", "044820", "009770", "092230", "091090", "090350", "032350", "049800", "035510", "088790", "023530", "086280", "084870", "086790", "001560", "079430", "083420", "083370", "083380", "084690", "071950", "084670", "042700", "004890", "010960", "073240", "079160", "081000", "014830", "041650", "023810", "078930", "058730", "034220", "034310", "074610", "025750", "007660", "035250", "037270", "072710", "071050", "072130", "034120", "036570", "071090", "069730", "006890", "011500", "069460", "069620", "027740", "036530", "069260", "033530", "058430", "068290", "067830", "030610", "034300", "017370", "024720", "064960", "037710", "020760", "033180", "063160", "055550", "021240", "058650", "051900", "047050", "042660", "051630", "049770", "034020", "010040", "003220", "036460", "007120", "000850", "033780", "009540", "024090", "006840", "006650", "035150", "035000", "033250", "033240", "019490", "029460", "024890", "017940", "018670", "023590", "014440", "011790", "010600", "025890", "024900", "023960", "023800", "025530", "031820", "000660", "023150", "005320", "023450", "016800", "024070", "030720", "025560", "030210", "017900", "025540", "003160", "011930", "019180", "021820", "027970", "006740", "000910", "020120", "016580", "013580", "011160", "021050", "012750", "015890", "027390", "016590", "011690", "025860", "018500", "011300", "012610", "017810", "011200", "017390", "025820", "011090", "007460", "025620", "017960", "025000", "010580", "007980", "009440", "008420", "016880", "007310", "008500", "014790", "010120", "009190", "000760", "014820", "009680", "010690", "000390", "009450", "012030", "005090", "005750", "005880", "008560", "005870", "017550", "011170", "001430", "008770", "014580", "013520", "006060", "014530", "002140", "016090", "001620", "017040", "011390", "011810", "010130", "012600", "001500", "008870", "008110", "005820", "008490", "014910", "003580", "015860", "014160", "012280", "019170", "002210", "012170", "009420", "011330", "012800", "013360", "001140", "013700", "002760", "007610", "004920", "009290", "011420", "004270", "001940", "009410", "007280", "009180", "002170", "017670", "010640", "003650", "004380", "002840", "007860", "013000", "012330", "015540", "009320", "005440", "015760", "006280", "009160", "008600", "015230", "007160", "014130", "008040", "009140", "014990", "010420", "003610", "015590", "014680", "006040", "008060", "003680", "015020", "011280", "002310", "010660", "001770", "018470", "005850", "012510", "007630", "008250", "006370", "006980", "002920", "002220", "002450", "002460", "007340", "000890", "001290", "003010", "014280", "009810", "008730", "009270", "004140", "002960", "005810", "001270", "004710", "005190", "016610", "008930", "005500", "005490", "002410", "005690", "006340", "005950", "016360", "002810", "001750", "011780", "003470", "002620", "015260", "009460", "005720", "006660", "004490", "011000", "010100", "005070", "004830", "001720", "001200", "003460", "011700", "005420", "000500", "011230", "004020", "004770", "006090", "009470", "001510", "016380", "010780", "007810", "004170", "010060", "000520", "006490", "003120", "002710", "003060", "007700", "008700", "006360", "006110", "006400", "009150", "004200", "005960", "009070", "003070", "005180", "005250", "005450", "004310", "008350", "003350", "001880", "006260", "001740", "002100", "004870", "007590", "004430", "002780", "004090", "000650", "001080", "004700", "004360", "008970", "002880", "001260", "005680", "005800", "002630", "001550", "005430", "004910", "004690", "003080", "002600", "001570", "002070", "003570", "004960", "004370", "003720", "004980", "004970", "002870", "001630", "005740", "002390", "001380", "006120", "007540", "003280", "001250", "002990", "001470", "001820", "001020", "001520", "001060", "000670", "001340", "000180", "005110", "004450", "000040", "002240", "004100", "002820", "004840", "002350", "004060", "004000", "000020", "000210", "001120", "005030", "000590", "005390", "000990", "000220", "005940", "006800", "002700", "001360", "000810", "000370", "008260", "000490", "004540", "001420", "002020", "000300", "001460", "003620", "003410", "005610", "010050", "007570", "002320", "002200", "005380", "005360", "009830", "002030", "001070", "004410", "000680", "001210", "000140", "000320", "000270", "004800", "000150", "005010", "005830", "003090", "003780", "003520", "002380", "003200", "006220", "004150", "007210", "002300", "000400", "001130", "001680", "003550", "003690", "000970", "004250", "003030", "001440", "001790", "000070", "002420", "000950", "001530", "000120", "000060", "000050", "000700", "003480", "256150", "329560", "311390", "195500", "328380", "286750", "317830", "228670", "186230", "282880", "317330", "318000", "148150", "313760", "317850", "241840", "300080", "323210", "234340", "289010", "251970", "312610", "323280", "323940", "323230", "293780", "308100", "305090", "322780", "321260", "253840", "307930", "319660", "319400", "950180", "317320", "317240", "125210", "228760", "317030", "099750", "313750", "100790", "247540", "299660", "278280", "246960", "053580", "238200", "311270", "310840", "263050", "290550", "310200", "307180", "309930", "299900", "310870", "307750", "298380", "100590", "110020", "270870", "307870", "302430", "307070", "290120", "307280", "128540", "299910", "900340", "307160", "111710", "179290", "117730", "290660", "246710", "263690", "027360", "208340", "263020", "227100", "268600", "285490", "290650", "306620", "108490", "153710", "288620", "293580", "290720", "110790", "299170", "219750", "257370", "291230", "197140", "303030", "290740", "173130", "089970", "086820", "290380", "275630", "290270", "080720", "204020", "297570", "226950", "175250", "289080", "245620", "284620", "037030", "016790", "258830", "122310", "291210", "287410", "950170", "263700", "064510", "277070", "226400", "183490", "006620", "154030", "260660", "042000", "219420", "267790", "255220", "264660", "269620", "281410", "187870", "281740", "260930", "234300", "066360", "007680", "138580", "279410", "253450", "276920", "148140", "950160", "265560", "234100", "277480", "263810", "255440", "277410", "263920", "243840", "179900", "171090", "259630", "174900", "256940", "263600", "258610", "270520", "140670", "900310", "273060", "118990", "263860", "263720", "091990", "181340", "271740", "238490", "251630", "227610", "261200", "267320", "250000", "265920", "225190", "264850", "161580", "265480", "264290", "251370", "258790", "263770", "063760", "264450", "178320", "183300", "246720", "262830", "217480", "002800", "083500", "087260", "257730", "241820", "140070", "206650", "256840", "195440", "241520", "246690", "147760", "204990", "196300", "203450", "215600", "254120", "241790", "220100", "144960", "156100", "176440", "237880", "900300", "238120", "252500", "216050", "239610", "241710", "900290", "900280", "189300", "072990", "238090", "050960", "201490", "250930", "241690", "250060", "242040", "234920", "900270", "230360", "038160", "208860", "073560", "123010", "174880", "071460", "142760", "237750", "900260", "144510", "148250", "239340", "243070", "240810", "228850", "225330", "228340", "222110", "211270", "230980", "115180", "065660", "236200", "226350", "142210", "900250", "221610", "109610", "224060", "232140", "191410", "223310", "145020", "222980", "206560", "013310", "217730", "047920", "133750", "225530", "140860", "230240", "122640", "222040", "058110", "217820", "213090", "221840", "197210", "127160", "221980", "212560", "227950", "185490", "190510", "056090", "226340", "115960", "182400", "092870", "226360", "214870", "225430", "226440", "225590", "225570", "217190", "219130", "175140", "225650", "222080", "220630", "224110", "196700", "131760", "222810", "222800", "189980", "094360", "127710", "214430", "220260", "214450", "219550", "087010", "218410", "094170", "214180", "178780", "160600", "217600", "166480", "214310", "177350", "218150", "160980", "217500", "087600", "217620", "187420", "215380", "215480", "215790", "215360", "215200", "215090", "215100", "195990", "215000", "214150", "214270", "189690", "213420", "060480", "206640", "193250", "204630", "200470", "200670", "208710", "189860", "067390", "080580", "208350", "124500", "142280", "187220", "208370", "208140", "149980", "084650", "200710", "200780", "207760", "196170", "206400", "178920", "205470", "200230", "194510", "204620", "196490", "205500", "205100", "191420", "192440", "182690", "143540", "203650", "041920", "194480", "203690", "192410", "198440", "187270", "177830", "090410", "004650", "192390", "059120", "105550", "196450", "071850", "187790", "192250", "138080", "108790", "053300", "090850", "184230", "049080", "150840", "085810", "170030", "134580", "171120", "171010", "161570", "076610", "168330", "131970", "150900", "170920", "119850", "092040", "170790", "151860", "089600", "950130", "141080", "158310", "097800", "159580", "114810", "153490", "141020", "159910", "950110", "046970", "113810", "141070", "155650", "149950", "121850", "151910", "097520", "153460", "106520", "137400", "141000", "072950", "143240", "126870", "147830", "091590", "140410", "104830", "127120", "130580", "131090", "100660", "115480", "123260", "139670", "121800", "112240", "138070", "122870", "136510", "089530", "089030", "101240", "007820", "115530", "043290", "090360", "131220", "131390", "143160", "137950", "040910", "139050", "089980", "138610", "108380", "019770", "137940", "131100", "138690", "122450", "121440", "136540", "136480", "104480", "008470", "121600", "093320", "130740", "131180", "061970", "126880", "033560", "048530", "119860", "131370", "064290", "131290", "131400", "120240", "131030", "096690", "033830", "033170", "122800", "041460", "105740", "126600", "123420", "123860", "058400", "069140", "119830", "101930", "078650", "068940", "123840", "117670", "068240", "096530", "122990", "126700", "126640", "123410", "123040", "067920", "119610", "106190", "114120", "121890", "111820", "046120", "070300", "108320", "079970", "071200", "100030", "122690", "900110", "900100", "115500", "900120", "115450", "122350", "115610", "106080", "101330", "114570", "115570", "115440", "050860", "114630", "080530", "900070", "099520", "114450", "104460", "096640", "112040", "108860", "900080", "088290", "114190", "115160", "109960", "099410", "101000", "082920", "042520", "104200", "052860", "105330", "109740", "095700", "108230", "100130", "103230", "063080", "109860", "102120", "101730", "900040", "102710", "099440", "102210", "099220", "101680", "010240", "101170", "081150", "071670", "101490", "100120", "102940", "101400", "086890", "104040", "078070", "086900", "058630", "059100", "067630", "092130", "100700", "098120", "083470", "100090", "101390", "076080", "101670", "063170", "047560", "096240", "101160", "099320", "064480", "098460", "018620", "095610", "096870", "059210", "097870", "087730", "091440", "096040", "097780", "096630", "068330", "093920", "096350", "069920", "096610", "092070", "094820", "086670", "095190", "092300", "093640", "095910", "081580", "073110", "094970", "080520", "095340", "086040", "090740", "057540", "094940", "095270", "093190", "091340", "072770", "094480", "086520", "065150", "069410", "093380", "086450", "064820", "091580", "092460", "073540", "091120", "094860", "078020", "093520", "048260", "091970", "092730", "090460", "039200", "089010", "090470", "088130", "084110", "091700", "086390", "090710", "060540", "066310", "067280", "086250", "089890", "080470", "089140", "089790", "090150", "089230", "043150", "086960", "038060", "083660", "062860", "063570", "086980", "068050", "085370", "039290", "078860", "088910", "054950", "084730", "086060", "022220", "068760", "083450", "019990", "079370", "046110", "085670", "084370", "083790", "064550", "084990", "083640", "085660", "078140", "067900", "083550", "084180", "050540", "080420", "083650", "079190", "045890", "082800", "043910", "079000", "041020", "078590", "038070", "079940", "077360", "083930", "067310", "082660", "080010", "058220", "078160", "082850", "080160", "078890", "082210", "075130", "080440", "073490", "079960", "080220", "079170", "079810", "079650", "052900", "066910", "052460", "072870", "073010", "078600", "054450", "078150", "067990", "051360", "072520", "078130", "068790", "078940", "048870", "065350", "011080", "050090", "057030", "065770", "074430", "077280", "066700", "066900", "078350", "075970", "069540", "073190", "054090", "041910", "073070", "039670", "067770", "070590", "073570", "073640", "065680", "057880", "060570", "066410", "067160", "071280", "041440", "067170", "054780", "072020", "065510", "072470", "068930", "069110", "069330", "052710", "065950", "047310", "056000", "041520", "065560", "064240", "066790", "067080", "066590", "067290", "066130", "046140", "065450", "065130", "065440", "049630", "021650", "051370", "065650", "065570", "066980", "016100", "065940", "042040", "066970", "066670", "066430", "047820", "064090", "049960", "053290", "064520", "065170", "041590", "042600", "065500", "060900", "066620", "065420", "052770", "064800", "039980", "048410", "058610", "045340", "065710", "065690", "066110", "043710", "060560", "036010", "060280", "065620", "060230", "057680", "046940", "060150", "065530", "051160", "065060", "049180", "060720", "061040", "054210", "050120", "054410", "060310", "061250", "053980", "054050", "039420", "039440", "049550", "054670", "060590", "049070", "060370", "051380", "053660", "034950", "060260", "060380", "046310", "058530", "049720", "052670", "046890", "013990", "058450", "059090", "050320", "054930", "035200", "048470", "060300", "042500", "058420", "040350", "054300", "054340", "047080", "060250", "053260", "060240", "056730", "041930", "054220", "058470", "045300", "056700", "054940", "043370", "054620", "056360", "043260", "038340", "051390", "054540", "054630", "056080", "044490", "053950", "053700", "054920", "041960", "053160", "052400", "054180", "049470", "053050", "043090", "053110", "054800", "047770", "040300", "058820", "035900", "053590", "021320", "053060", "053610", "053450", "053030", "052420", "053620", "052300", "048910", "051980", "049120", "043360", "052330", "052020", "043220", "051780", "052190", "051490", "038870", "045660", "052260", "045390", "050110", "038500", "049830", "044060", "024850", "048770", "049430", "044480", "046390", "014620", "048430", "017480", "049480", "036670", "042510", "046070", "041830", "014570", "045520", "022100", "033600", "044180", "044960", "032080", "044340", "042940", "048830", "000250", "044780", "045510", "045100", "040160", "043340", "043650", "037950", "039030", "038540", "018680", "039860", "046210", "045060", "043100", "042370", "045970", "040420", "007370", "043610", "039010", "043200", "042110", "039740", "039840", "038460", "039230", "032820", "001540", "038530", "039310", "041190", "036640", "030190", "038620", "039020", "038950", "036800", "040610", "038880", "038680", "010280", "036480", "038110", "032500", "039610", "039240", "037440", "028150", "036810", "036690", "037370", "036620", "037350", "001810", "036630", "036710", "037070", "036560", "016250", "036030", "035890", "036930", "032190", "005290", "036170", "036180", "026040", "037230", "037400", "033640", "037330", "036090", "036200", "024800", "036260", "027050", "035290", "027040", "027830", "036000", "035810", "035460", "035480", "035620", "035610", "020710", "012790", "034940", "033230", "035080", "005160", "031390", "033430", "025770", "033540", "033500", "030350", "033310", "033320", "009520", "013810", "033340", "033200", "033290", "015710", "033100", "033050", "033110", "033130", "032980", "019210", "026150", "031310", "032960", "032680", "032940", "008290", "032750", "032860", "032790", "032800", "032620", "032580", "032540", "028080", "032280", "031510", "031860", "031980", "011560", "024740", "030960", "030520", "021880", "021040", "029480", "028040", "028300", "027710", "023600", "018310", "003800", "025980", "026910", "017250", "015750", "020180", "025950", "025900", "025870", "025880", "002680", "025550", "025320", "024940", "024950", "014100", "024840", "024910", "004780", "013120", "024830", "024810", "024880", "024120", "017000", "024060", "023910", "001840", "023900", "023890", "017650", "010170", "023790", "023770", "023760", "005860", "012860", "023460", "006050", "023410", "023440", "006910", "018290", "023160", "011370", "018700", "014470", "007720", "006580", "011320", "018120", "013720", "009620", "005670", "007330", "006140", "019010", "009780", "008800", "020400", "014200", "005710", "016600", "004590", "016670", "000440", "014970", "011040", "008370", "007390", "002290", "019540", "007770", "017890", "003310", "019660", "017510", "021080", "008830", "002230", "009730", "016920", "013030", "019550", "019570", "019590", "006920"};
	public String[] col = {"Item", "C-A", "C-B-Correlation", "C-Mean", "C-Std", "b_C-Mean", "b_C-Std", "C-B-Index", "A-A", "A-B-Correlation", "A-Mean", "A-Std", "b_A-Mean", "b_A-Std", "A-B-Index", "Variation", "A-Bang"};
	
	public Integer idxLong = 60;
	public Integer bIndex = 20;
	public Integer adj = 0;
	public JSONArray req_array;
	public JSONObject restJsonObj;
	
	public JSONArray rArray;
	public JSONObject rObj;
	
	public JSONArray colArray;
	public JSONArray rowArray;
	
	public List<ELS> els = new ArrayList<>();


	//	@RequestMapping("/{teamcd}")
	//	public List<Yaba> Yaba(@PathVariable String teamcd) {
	//
	//		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	//		Object certChain = req.getAttribute("javax.servlet.request.X509Certificate");
	//
	//		String certName = null;
	//
	//		if (certChain != null) {
	//			X509Certificate certs[] = (X509Certificate[])certChain;
	//
	//			for(int i = 0; i < certs.length; i++) {
	//				X509Certificate cert = certs[i];
	//				certName = cert.getSubjectDN().getName();
	//				System.out.println(certName);
	//			}
	//		}
	//
	//		Yaba obj = new Yaba();
	//		obj.setTeamcd(teamcd);
	//
	//		List<Yaba> yaba = yabaMapper.readTeaminfo(teamcd);
	//
	//		return yaba;
	//	}

	@RequestMapping("/search")
	public String getSearch() {
		System.out.println("search");
		return "[\"upper_25\",\"upper_50\",\"upper_75\",\"upper_90\",\"upper_95\"]";
	}
	
	@RequestMapping("/annotations")
	public String getAnnotations() {
		System.out.println("annotations");
		return "[\r\n" + 
				"  {\r\n" + 
				"    \"text\": \"text shown in body\" // Text for the annotation. (required)\r\n" + 
				"    \"title\": \"Annotation Title\", // The title for the annotation tooltip. (optional)\r\n" + 
				"    \"isRegion\": true, // Whether is region. (optional) (http://docs.grafana.org/reference/annotations/#adding-regions-events)\r\n" + 
				"    \"time\": \"timestamp\", // Time since UNIX Epoch in milliseconds. (required)\r\n" + 
				"    \"timeEnd\": \"timestamp\", // Time since UNIX Epoch in milliseconds (required if `isRegion` is true )\r\n" + 
				"    \"tags\": [\"tag1\"], // Tags for the annotation. (optional)\r\n" + 
				"  }\r\n" + 
				"]";
	}
	
	
	@RequestMapping("/query")
	public String getYaba() throws InterruptedException {
		System.out.println("query");
		els = new ArrayList<>();
		restJsonObj = new JSONObject();
		req_array = new JSONArray();
		
		rArray = new JSONArray();
		rObj = new JSONObject();
		
		colArray = new JSONArray();
		rowArray = new JSONArray();
		
		JSONObject dataObj;
		String outStr = "";
		
		
//		for(int i = 0; i < col.length; i++) {
		for(int i = 0; i < 3; i++) {
			dataObj = new JSONObject();
			
			dataObj.put("text", col[i]);
			
			if(i > 0) {
				dataObj.put("type", "number");
			}else {
				dataObj.put("type", "string");
			}
			
			colArray.put(dataObj);
		}
		
		rObj.put("columns", colArray);
        
		System.out.print("\033[0m");
		for(int i=0;i<eArr.length;i++){
			getELS(eArr[i]);
//			getInfo(eArr[i]);
		}
		
		rObj.put("rows", rowArray);
		rObj.put("type", "table");
		rArray.put(rObj);
		
		
		System.out.println("-- sorting start --");
		els.sort(Comparator.naturalOrder());
		
//		for (int i = 0; i < els.size(); i++) {
//            System.out.print(els.get(i).getItm() + "\t");
//            System.out.print(els.get(i).getSurplus() + "\t");
//            System.out.print(els.get(i).getVariation() + "\t");
//            getInfo(els.get(i).getItm());
//		}
		System.out.print("\033[0m");
		System.out.print("\033[46m");
		System.out.print(String.format("%-10s%10s", "Itm", ""));
		System.out.print("\t");
		System.out.println(String.format("%10s%10s%10s%10s%10s%10s%10s", "Curr", "Variation", "YC-Rate", "B-B", "Index", "ER", "BR"));
		System.out.print("\033[0m");
		
		for (int i = 0; i < Math.min(els.size(), 50); i++) {
			if(els.get(i).getBollinger() < 30 && els.get(i).getIndex() > 0) {
				System.out.print("\033[43m");
			}else if(els.get(i).getBollinger() < 0 && els.get(i).getIndex() > 0) {
				System.out.print("\033[47m");
			}else {
				System.out.print("\033[0m");
			}
			
			System.out.print(String.format("%-10s%-10s"
					, els.get(i).getItm()
					, els.get(i).getName().toString().trim().substring(0, Math.min(els.get(i).getName().toString().length(), 10))
					));
			System.out.print("\t");
			System.out.print(String.format("%,10d%10.1f%10.1f%10.1f%10.1f"
					, Math.round(els.get(i).getCVal())
					, els.get(i).getSurplus()
					, els.get(i).getVariation()
					, els.get(i).getBollinger()
					, els.get(i).getIndex()));
			getInfo(els.get(i).getItm());
			System.out.print("\033[0m");
			
			if(els.get(i).getItm().equals("182360")) {
				outStr = outStr + "\t";				
				outStr = outStr + String.format("%-10s%-10s"
						, els.get(i).getItm()
//						, els.get(i).getName().toString().trim().substring(0, Math.min(els.get(i).getName().toString().length(), 10))
						, ""
						);
				outStr = outStr + "\t";
				outStr = outStr + String.format("%,10d%10.1f%10.1f%10.1f%10.1f"
						, Math.round(els.get(i).getCVal())
						, els.get(i).getSurplus()
						, els.get(i).getVariation()
						, els.get(i).getBollinger()
						, els.get(i).getIndex());
			}else if(els.get(i).getItm().equals("006620")) {
				outStr = outStr + "\t";
				outStr = outStr + String.format("%-10s%-10s"
						, els.get(i).getItm()
//						, els.get(i).getName().toString().trim().substring(0, Math.min(els.get(i).getName().toString().length(), 10))
						, ""
						);
				outStr = outStr + "\t";
				outStr = outStr + String.format("%,10d%10.1f%10.1f%10.1f%10.1f"
						, Math.round(els.get(i).getCVal())
						, els.get(i).getSurplus()
						, els.get(i).getVariation()
						, els.get(i).getBollinger()
						, els.get(i).getIndex());
			}else if(els.get(i).getItm().equals("255440")) {
				outStr = outStr + "\t";
				outStr = outStr + String.format("%-10s%-10s"
						, els.get(i).getItm()
//						, els.get(i).getName().toString().trim().substring(0, Math.min(els.get(i).getName().toString().length(), 10))
						, ""
						);
				outStr = outStr + "\t";
				outStr = outStr + String.format("%,10d%10.1f%10.1f%10.1f%10.1f"
						, Math.round(els.get(i).getCVal())
						, els.get(i).getSurplus()
						, els.get(i).getVariation()
						, els.get(i).getBollinger()
						, els.get(i).getIndex());
			}
		}

		System.out.println("-- Process ended --");
		outStr = "<H2>" + outStr + "</H2>";
		return outStr;
	}
	
	@RequestMapping("/info")
	public void getInfo(String itm) {
		
		URI uri = UriComponentsBuilder.newInstance().scheme("https").host("navercomp.wisereport.co.kr")
				.path("/v2/company/cF1002.aspx")
				.queryParam("cmp_cd", itm)
				.queryParam("finGubun", "MAIN")
				.queryParam("frq", "0")
				.build()
				.encode(Charset.forName("EUC-KR"))
				.toUri();
		
		String html = getHtml(uri.toString());
		JSONObject json = XML.toJSONObject(html);
		
		JSONObject jTable = (JSONObject)json.get("table");
		JSONObject jTbody = (JSONObject)jTable.get("tbody");
		
		try {
			JSONArray jRow = (JSONArray)jTbody.get("tr");
			JSONArray jItm = (JSONArray)((JSONObject)jRow.get(jRow.length()-1)).get("td");
			
			if(((JSONObject)jItm.get(6)).length() > 1 && ((JSONObject)jItm.get(7)).length() > 1) {
				System.out.print(String.format("%10.2f", ((JSONObject)jItm.get(6)).get("content")));
				System.out.println(String.format("%10.2f",((JSONObject)jItm.get(7)).get("content")));
			}else if(jRow.length() > 1) {
				jItm = (JSONArray)((JSONObject)jRow.get(jRow.length()-2)).get("td");
				
				if(((JSONObject)jItm.get(6)).length() > 1 && ((JSONObject)jItm.get(7)).length() > 1) {
					System.out.print(String.format("%10.2f",((JSONObject)jItm.get(6)).get("content")));
					System.out.println(String.format("%10.2f",((JSONObject)jItm.get(7)).get("content")));
				}else if(jRow.length() > 2) {
					jItm = (JSONArray)((JSONObject)jRow.get(jRow.length()-3)).get("td");
					
					if(((JSONObject)jItm.get(6)).length() > 1 && ((JSONObject)jItm.get(7)).length() > 1) {
						System.out.print(String.format("%10.2f",((JSONObject)jItm.get(6)).get("content")));
						System.out.println(String.format("%10.2f",((JSONObject)jItm.get(7)).get("content")));
					}else {
						System.out.println(String.format("%10s", "-"));
					}
				}else {
					System.out.println(String.format("%10s", "-"));
				}
			}else {
				System.out.println(String.format("%10s", "-"));
			}
		}catch(Exception e){
			System.out.println(String.format("%10s", "-"));
		}
	}
	
	public void getELS(String itm) {
		String ELS = null;
		double amtMax = 0.0;

		URI uri = UriComponentsBuilder.newInstance().scheme("https").host("fchart.stock.naver.com")
				.path("/sise.nhn")
				.queryParam("symbol", itm)
				.queryParam("timeframe", "day")
				.queryParam("count", idxLong.toString())
				.queryParam("requestType", "0")
				.build()
				.encode(Charset.forName("EUC-KR"))
				.toUri();

		String html = getHtml(uri.toString());

		JSONObject json = XML.toJSONObject(html);
		JSONObject jRoot = (JSONObject)json.get("protocol");
		JSONObject jItem = (JSONObject)jRoot.get("chartdata");
		JSONArray jArr = (JSONArray) jItem.get("item");
		
		if(jArr.length() < idxLong) {
//			System.out.println(itm + "|" + jArr.length());
//			return;
		}

		StandardDeviation cStd = new StandardDeviation();
		StandardDeviation aStd = new StandardDeviation();

		Mean cMean = new Mean();
		Mean aMean = new Mean();
		
		StandardDeviation b_cStd = new StandardDeviation();
		StandardDeviation b_aStd = new StandardDeviation();

		Mean b_cMean = new Mean();
		Mean b_aMean = new Mean();
		
		Sum cR1 = new Sum();
		Sum cR2 = new Sum();
		Sum aR1 = new Sum();
		Sum aR2 = new Sum();
		
		Double cA = 0.0;	// linear A
		Double cB = 0.0;	// linear B

		Double aA = 0.0;	// linear A
		Double aB = 0.0;	// linear B

		JSONObject BiasJsonObj = (JSONObject)jArr.get(jArr.length()-adj-1);
		String BiasJData = (String)BiasJsonObj.get("data");
		
		Double BiasCVal = Double.parseDouble(BiasJData.split("\\|")[4]);
		Double BiasAVal = Double.parseDouble(BiasJData.split("\\|")[5]);
		
		BiasCVal = 10000.0 / BiasCVal;
		BiasAVal = 10000.0 / BiasAVal;
		
		// Calc Std & Mean
		for(int i=0;i<jArr.length()-adj;i++){
			JSONObject jsonObj2 = (JSONObject)jArr.get(i);
			String jData = (String)jsonObj2.get("data");

			Double cVal = Double.parseDouble(jData.split("\\|")[4])*BiasCVal;
			Double aVal = Double.parseDouble(jData.split("\\|")[5])*BiasAVal;
			
			if(i < jArr.length()-adj-1) {
				amtMax = Math.max(Double.parseDouble(jData.split("\\|")[5]), amtMax);
			}
			
//			System.out.println(cVal);
			
			cStd.increment(cVal);
			cMean.increment(cVal);
			aStd.increment(aVal);
			aMean.increment(aVal);
		}
		
		// B-Index
		for(int i=jArr.length()-adj-bIndex;i<jArr.length()-adj;i++){
			JSONObject jsonObj2 = (JSONObject)jArr.get(i);
			String jData = (String)jsonObj2.get("data");

			Double cVal = Double.parseDouble(jData.split("\\|")[4])*BiasCVal;
			Double aVal = Double.parseDouble(jData.split("\\|")[5])*BiasAVal;
			
			b_cStd.increment(cVal);
			b_cMean.increment(cVal);
			b_aStd.increment(aVal);
			b_aMean.increment(aVal);
		}

		//	Correlation coefficient
		for(int i=0;i<jArr.length()-adj;i++){
			JSONObject jsonObj2 = (JSONObject)jArr.get(i);
			String jData = (String)jsonObj2.get("data");

			Double cVal = Double.parseDouble(jData.split("\\|")[4])*BiasCVal;
			Double aVal = Double.parseDouble(jData.split("\\|")[5])*BiasAVal;

			cR1.increment((i + 1 - (jArr.length()-adj)/2 + 0.5) * (cVal - cMean.getResult()));
			cR2.increment((i + 1 - (jArr.length()-adj)/2 + 0.5) * (i + 1 - (jArr.length()-adj)/2 + 0.5));
			aR1.increment((i + 1 - (jArr.length()-adj)/2 + 0.5) * (aVal - aMean.getResult()));
			aR2.increment((i + 1 - (jArr.length()-adj)/2 + 0.5) * (i + 1 - (jArr.length()-adj)/2 + 0.5));
		}

		cB = cR1.getResult()/cR2.getResult();
		cA = cMean.getResult() - cB * ((jArr.length()-adj)/2 + 0.5);
		
		aB = aR1.getResult()/aR2.getResult();
		aA = aMean.getResult() - aB * ((jArr.length()-adj)/2 + 0.5);

		JSONObject jsonObj2 = (JSONObject)jArr.get(jArr.length()-1-adj);
		String jData = (String)jsonObj2.get("data");

		if(eArr.length <= 5) {
			System.out.println("#|" + itm);
			
			System.out.println("A|" + cA);
			System.out.println("B|" + cB);
			System.out.println("Mean|" + cMean.getResult());
			System.out.println("Std|" + cStd.getResult());
			System.out.println("B-Index|" + Math.round((Double.parseDouble(jData.split("\\|")[4])*BiasCVal - b_cMean.getResult()) / (2*b_cStd.getResult()) * 10000)/1000.0);
			
			System.out.println("A|" + aA);
			System.out.println("B|" + aB);
			System.out.println("Mean|" + aMean.getResult());
			System.out.println("Std|" + aStd.getResult());
			System.out.println("B-Index|" + Math.round((Double.parseDouble(jData.split("\\|")[5])*BiasAVal - b_aMean.getResult()) / (2*b_aStd.getResult()) * 10000)/1000.0);
			
			System.out.println("|" + Double.parseDouble(jData.split("\\|")[4])*BiasCVal);
			
			JSONObject jsonObj3 = (JSONObject)jArr.get(jArr.length()-2);
			String jData3 = (String)jsonObj3.get("data");
			
			System.out.println("|" + Double.parseDouble(jData3.split("\\|")[4])*BiasCVal);
		}else {
			if(aA.isNaN()) return;
			
			JSONObject jsonObj3 = (JSONObject)jArr.get(jArr.length()-2-adj);
			String jData3 = (String)jsonObj3.get("data");
			
			if(Double.parseDouble(jData3.split("\\|")[5]) == 0) return;
			
			Double b1 = Double.parseDouble(jData.split("\\|")[4])*BiasCVal;
			Double b2 = Double.parseDouble(jData3.split("\\|")[4])*BiasCVal;
			
//			if(amtMax / Double.parseDouble(jData3.split("\\|")[5]) < 3) {
//			if(Math.round(amtMax / Double.parseDouble(jData3.split("\\|")[5]) * 100)/100.0 < 2) {
			if(1>0) {	
				System.out.print(itm);
				System.out.print("\t" + cA);
				System.out.print("\t" + cB);
				System.out.print("\t" + cMean.getResult());
				System.out.print("\t" + cStd.getResult());
				System.out.print("\t" + b_cMean.getResult());
				System.out.print("\t" + b_cStd.getResult());
				System.out.print("\t" + Math.round((Double.parseDouble(jData.split("\\|")[4])*BiasCVal - b_cMean.getResult()) / (2*b_cStd.getResult()) * 1000)/10.0);
				System.out.print("\t" + aA);
				System.out.print("\t" + aB);
				System.out.print("\t" + aMean.getResult());
				System.out.print("\t" + aStd.getResult());
				System.out.print("\t" + b_aMean.getResult());
				System.out.print("\t" + b_aStd.getResult());
				System.out.print("\t" + Math.round((Double.parseDouble(jData.split("\\|")[5])*BiasAVal - b_aMean.getResult()) / (2*b_aStd.getResult()) * 1000)/10.0);
				
				System.out.print("\t" + Math.round((b2-b1)/b1*10000)/100.0);
				System.out.print("\t" + Double.parseDouble(jData3.split("\\|")[5])*BiasAVal/aMean.getResult());
				System.out.println("\t" + Math.round(amtMax / Double.parseDouble(jData3.split("\\|")[5]) * 100)/100.0);
				
				els.add(new ELS(jItem.get("name").toString()
						, itm
						, Math.round((b1-b2)/b2*10000)/100.0
						, amtMax / Double.parseDouble(jData.split("\\|")[5])
						, Math.round((Double.parseDouble(jData.split("\\|")[4])*BiasCVal - b_cMean.getResult()) / (2*b_cStd.getResult()) * 1000)/10.0
						, Double.parseDouble(jData.split("\\|")[4])
						, (b1 - b_cMean.getResult())*(10000.0/b1) 
						));
				
				if(aA.isNaN()) return;
				
				JSONArray data = new JSONArray();
				data.put(itm);
				data.put(cA);
				data.put(cB);
				data.put(cMean.getResult());
				data.put(cStd.getResult());
				data.put(b_cMean.getResult());
				data.put(b_cStd.getResult());
				data.put(Math.round((Double.parseDouble(jData.split("\\|")[4])*BiasCVal - b_cMean.getResult()) / (2*b_cStd.getResult()) * 10000)/1000.0);
				data.put(aA);
				data.put(aB);
				data.put(aMean.getResult());
				data.put(aStd.getResult());
				data.put(b_aMean.getResult());
				data.put(b_aStd.getResult());
				data.put(Math.round((Double.parseDouble(jData.split("\\|")[5])*BiasAVal - b_aMean.getResult()) / (2*b_aStd.getResult()) * 10000)/1000.0);
				data.put(Math.round((b2-b1)/b1*10000)/100.0);
				data.put(Double.parseDouble(jData3.split("\\|")[5])*BiasAVal/aMean.getResult());
				data.put(amtMax / Double.parseDouble(jData3.split("\\|")[5]));
		        
		        rowArray.put(data);
			}
			
		}
	}

//	JSONObject jsonObject = new JSONObject();
//
//    jsonObject.put("SECR_KEY", "ktko.tistory.com");
//    jsonObject.put("KEY", "ktko");
//    
//    JSONObject data = new JSONObject();
//    data.put("BANK_CD", "088");
//    data.put("SEARCH_ACCT_NO", "1231231234");
//    data.put("ACNM_NO", "123456");
//    data.put("ICHE_AMT", "0");
//    data.put("TRSC_SEQ_NO", "0000001");
//    
//    JSONArray req_array = new JSONArray();
//    req_array.add(data);
//    
//    jsonObject.put("REQ_DATA", req_array);

	public JSONObject parseXmlToJson(String xml){
		JSONObject json = XML.toJSONObject(xml);
		return json; 
	}

	public String getHtml(String url) {
		try {
			URL targetUrl = new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream(), Charset.forName("EUC-KR")));
			StringBuilder html = new StringBuilder();
			String current = "";

			while ((current = reader.readLine()) != null) {
				html.append(current);
			}

			reader.close();
			return html.toString();

		} catch (MalformedURLException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}

		return null;
	}
}
