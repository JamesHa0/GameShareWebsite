-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.26 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 game_db 的数据库结构
CREATE DATABASE IF NOT EXISTS `game_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `game_db`;

-- 导出  表 game_db.game 结构
CREATE TABLE IF NOT EXISTS `game` (
  `gid` int NOT NULL AUTO_INCREMENT COMMENT '游戏id',
  `gname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '游戏名',
  `gprice` decimal(10,2) DEFAULT NULL COMMENT '单价（站内：积分；站外：RMB）',
  `gdeveloper` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '未知' COMMENT '游戏开发商',
  `gpublisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '未知' COMMENT '游戏发行商',
  `grelease_date` varchar(50) DEFAULT NULL COMMENT '游戏发行日期',
  `gdescription` varchar(9999) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '发行人很懒，连简介都懒得写' COMMENT '游戏简介',
  `gzhname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '（发行人不愿意说出它的中文名）' COMMENT '游戏中文名',
  `gtag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '未知' COMMENT '游戏类型（动作、冒险、模拟、角色扮演、休闲和其他）',
  PRIMARY KEY (`gid`) USING BTREE,
  UNIQUE KEY `gname` (`gname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100000043 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='游戏表';

-- 正在导出表  game_db.game 的数据：~15 rows (大约)
INSERT IGNORE INTO `game` (`gid`, `gname`, `gprice`, `gdeveloper`, `gpublisher`, `grelease_date`, `gdescription`, `gzhname`, `gtag`) VALUES
	(49520, 'Borderlands 2', 64.00, '\r\nGearbox Software', '\r\n2K', '2012-09-21', 'A new era of shoot and loot is about to begin. Play as one of four new vault hunters facing off against a massive new world of creatures, psychos and the evil mastermind, Handsome Jack. Make new friends, arm them with a bazillion weapons and fight alongside them in 4 player co-op on a relentless quest for revenge and redemption across the undiscovered and unpredictable living planet.<br/><br/>\r\nKey Features:<br/>\r\nAll-New Characters and All-New Classes: Four all new playable classes including the Siren, the Commando, the Gunzerker and the Assassin. Step into the role of the Gunzerker, whose highly deadly skills allow him to dual-wield any two weapons found in the game. Not only that, you will build on that skill to do more things with two guns than you ever imagined possible. Dual machine guns? Cool. Dual rocket launchers? Of course! Dual Sniper Rifles? Sure, if that’s your thing! Want to try other styles? More tactical perhaps? There are multiple classes to choose from!<br/>\r\n\r\nDynamic Co-op online, and LAN: Share your adventures with friends both online and via LAN. Borderlands 2 features a seamless system enabling you to drop in and drop out of a campaign without ever having to restart the game. On top of that you can even take your new gear from any game to any other!<br/>\r\n\r\nWorld Connected Story: Find yourself left for dead in the frozen tundra of Pandora as you begin your quest of revenge and redemption. Expose the evil surrounding the Hyperion Corporation and take on the perpetrator of a universe-wide grand deception -- the nefarious Hyperion CEO, Handsome Jack. (Oh, also: he\'s stolen credit for the opening of the Vault.)<br/>\r\n\r\n87 Bazillion...Everything: In addition to the new gun system, you will lust after procedurally generated shields, grenades, Relics, class mods and much, much more. And you thought the original Borderlands had a ton of loot!<br/>\r\n\r\nBrand new environments on Pandora: Hunt through entirely brand new areas of Pandora that are more alive than ever! From the arctic tundra, through the dangerous grasslands, past the mysterious corrosive caverns to beyond, you’ll be surprised by the unpredictable world of Pandora at every turn!\r\n<br/>\r\nBrand new enemies: A whole slew of new enemies are out there to kill you in Borderlands 2. Hulking, gorilla-like Bullymongs, vicious predatory Stalkers and the Hyperion mechanical army, run by Handsome Jack, are just some of the new enemies in Borderlands 2.', '无主之地2', '动作，角色扮演'),
	(205100, 'Dishonored', 41.00, '\r\nArkane Studios', '\r\nBethesda Softworks', '2012-10-09', 'Dishonored is an immersive first-person action game that casts you as a supernatural assassin driven by revenge. With Dishonored’s flexible combat system, creatively eliminate your targets as you combine the supernatural abilities, weapons and unusual gadgets at your disposal. Pursue your enemies under the cover of darkness or ruthlessly attack them head on with weapons drawn. The outcome of each mission plays out based on the choices you make.<br/><br/>\r\nStory:<br/>\r\nDishonored is set in Dunwall, an industrial whaling city where strange steampunk- inspired technology and otherworldly forces coexist in the shadows. You are the once-trusted bodyguard of the beloved Empress. Framed for her murder, you become an infamous assassin, known only by the disturbing mask that has become your calling card. In a time of uncertainty, when the city is besieged by plague and ruled by a corrupt government armed with industrial technologies, dark forces conspire to bestow upon you abilities beyond those of any common man – but at what cost? The truth behind your betrayal is as murky as the waters surrounding the city, and the life you once had is gone forever.<br/>\r\nKey features:<br/><br/>\r\nImprovise and Innovate<br/>\r\n<br/>\r\nApproach each assassination with your own style of play. Use shadow and sound to your advantage to make your way silently through levels unseen by foes, or attack enemies head-on as they respond to your aggression. The flexible combat system allows you to creatively combine your abilities, supernatural powers and gadgets as you make your way through the levels and dispatch your targets. Improvise and innovate to define your play style.<br/><br/>\r\nAction with Meaning<br/>\r\n\r\nThe world of Dishonored reacts to how you play. Move like a ghost and resist corruption, or show no mercy and leave a path of destruction in your wake. Decide your approach for each mission, and the outcomes will change as a result.<br/><br/>\r\nSupernatural Abilities<br/>\r\n\r\nTeleport for stealth approaches, possess any living creature, or stop time itself to orchestrate unearthly executions! Combining your suite of supernatural abilities and weapons opens up even more ways to overcome obstacles and eliminate targets. The game’s upgrade system allows for the mastery of deadly new abilities and devious gadgets.<br/><br/>\r\nA City Unlike Any Other<br/>\r\n\r\nEnter an original world envisioned by Half-Life 2 art director Viktor Antonov. Arkane and Bethesda bring you a steampunk city where industry and the supernatural collide, creating an atmosphere thick with intrigue. The world is yours to discover.', '耻辱', '动作，冒险'),
	(268050, 'The Evil Within', 83.00, '\r\nTango Gameworks', '\r\nBethesda Softworks', '2014-10-14', 'Developed by Shinji Mikami -- creator of the seminal Resident Evil series -- and the talented team at Tango Gameworks, The Evil Within embodies the meaning of pure survival horror. Highly-crafted environments, horrifying anxiety, and an intricate story are combined to create an immersive world that will bring you to the height of tension. With limited resources at your disposal, you’ll fight for survival and experience profound fear in this perfect blend of horror and action.\r\n<br/><br/>\r\n\r\nSTORY:<br/>\r\n\r\nWhile investigating the scene of a gruesome mass murder, Detective Sebastian Castellanos and his partners encounter a mysterious and powerful force. After seeing the slaughter of fellow officers, Sebastian is ambushed and knocked unconscious. When he awakens, he finds himself in a deranged world where hideous creatures wander among the dead.<br/>\r\nFacing unimaginable terror, and fighting for survival, Sebastian embarks on a frightening journey to unravel what’s behind this evil force.<br/><br/>\r\nKEY FEATURES:<br/>\r\nPure Survival Horror Returns<br/>\r\nShinji Mikami, the father of survival horror, is back to direct a chilling new game wrapped in haunting narrative. Tension and anxiety heighten dramatically as you explore the game’s tortured world.<br/>\r\n\r\nBrutal Traps and Twisted Creatures<br/>\r\nFace unthinkable horrors and cruel traps as you struggle to survive against overwhelming odds. Turn evil against itself by using the same diabolical devices against overwhelming deadly creatures.<br/>\r\n\r\nUnknown Threats in an Uncertain World<br/>\r\nMysterious and wicked fears loom ahead in a world that warps and twists around you. Corridors, walls, doors, and entire buildings change in real-time, ensnaring players in a reality where threats can appear at any time and from any direction.<br/>\r\n\r\nThe New Face of Horror<br/>\r\nExperience a disturbing reality as you try to break free from warped machinations that could only exist in the most horrifying worlds. Defeat insurmountable terror and experience the ultimate thrill by discovering The Evil Within.<br/>', '恶灵附身', '动作'),
	(413410, 'Danganronpa: Trigger Happy Havoc', 68.00, '\r\nSpike Chunsoft Co., Ltd., Abstraction Games', '\r\nSpike Chunsoft Co., Ltd.', '2016-02-18', 'Hope\'s Peak Academy is home to Japan\'s best and brightest high school students—the beacons of hope for the future. But that hope suddenly dies when Makoto Naegi and his classmates find themselves imprisoned in the school, cut off from the outside world and subject to the whims of a strange, murderous little bear named Monokuma. He pits the students against each other, promising freedom to anyone who can murder a fellow classmate and get away with it.<br/>\r\nIt\'s up to you to find out who Monokuma really is, and why you\'ve been taken from the world you once knew. But be careful what you wish for—sometimes there’s nothing more deadly than the truth...', '弹丸论破：希望的学园和绝望高中生 ', '冒险'),
	(1086940, 'Bordur\'s Gate3', 298.00, 'Larian Studios', 'Larian Studios', '2023-08-03', '召集你的队伍，返回被遗忘的国度，开启一段充满友谊与背叛、牺牲与生存，以及至高无上力量诱惑的传奇故事。\r\n<br/>\r\n神秘的力量正在你体内苏醒，而这一切都来源于夺心魔种在你大脑里的寄生虫。反抗吧，将黑暗的力量反掌为用。你也可以选择接受这种腐化，变成终极的邪恶。\r\n<br/>\r\n来自《神界：原罪2》的创作团队所打造的次时代RPG，故事将在D&D（龙与地下城）的世界中展开。\r\n<br/>\r\n你可以从D&D玩家手册中的12个职业与11个种族中进行选择，或者直接扮演一个带有精心设计背景的起源英雄。无论你是踏上冒险之旅，还是去获取战利品，亦或是投身战斗，或者展开罗曼史，这些都将贯穿你在被遗忘的国度以及其他位面的冒险旅程。你可以选择单独游玩，或者是与最多三名队友一起进行联机游戏。\r\n<br/>\r\n被劫持，被感染，陷入迷失。你正在变成一个怪物，但随着你体内的腐化力量的增长，你的力量也在增强。这力量可能能帮助你生存下来，但接受它的同时，你必将付出某种代价。然而，超越任何能力，你与队友之间建立的信任纽带可能会成为你最大的力量。在恶魔、诸神和邪恶的其他世界力量之间的冲突中，你将与队友共同决定被遗忘国度的命运。', '博德之门3', '冒险，角色扮演，策略'),
	(1091500, 'Cyberpunk 2077', 298.00, '\r\nCD PROJEKT RED', '\r\nCD PROJEKT RED', '2020-12-10', '《赛博朋克 2077》的舞台位于大都会夜之城，是一款在开放世界动作冒险角色扮演游戏。您扮演一位赛博朋克雇佣兵, 身陷绝地求生、不成功便成仁的险境。经过改进的同时更有全新免费额外内容加入。接受任务、累积声望、解锁升级，自定义您的人物和玩法。玩家经营的人际关系和做出的选择将会改变剧情的走向和身边的世界。这里是传奇诞生的地方。您的传奇又在哪里？\r\n<br/>\r\n享受 2.1 版本的沉浸式体验\r\n2.1 版本免费更新让夜之城更加充满活力！搭乘全面投运的 NCART 地铁系统；一边探索城市，一边用电台端口收听音乐；在 V 的公寓里和伴侣约会；参加可重复游玩的车赛；驾驶全新载具；享受改善后的摩托车战斗和操作手感；探索隐藏的秘密以及更多内容！\r\n<br/>\r\n创造属于你的赛博朋克\r\n装备赛博增强科技，化身城市法外之徒，在夜之城的街头谱写属于你的传奇。\r\n<br/>\r\n探索未来都市\r\n夜之城充斥着丰富的活动，看不完的风景，以及各式各样的人。去哪里，什么时候去，怎么去，全都取决于你自己。\r\n<br/>\r\n打造您的传奇\r\n展开大胆的冒险，和令人难忘的角色起建立亲密关系。您作出的选择决定了他们最终的命运。\r\n<br/>\r\n推出改良内容\r\n体验《赛博朋克 2077》在游戏性、经济系统、城市、地图使用等方面的大量改良内容。', '赛博朋克 2077', '角色扮演'),
	(1174180, 'Red Dead Redemption 2', 279.00, '\r\nRockstar Games', '\r\nRockstar Games', '2019-12-06', '美国，1899 年。\r\n<br/>\r\n亚瑟·摩根和范德林德帮众是一群逃亡在外的亡命之徒。联邦侦探和全国顶尖的赏金猎人在他们的身后穷追不舍，亚瑟一行人必须在广袤蛮荒的美国腹地上四处劫掠、挣扎求生。而帮派内部的矛盾分化日渐加深，摆在亚瑟面前的将是他无法避免的抉择：究竟是选择自己的理想，还是选择效忠于抚养了自己的帮派。\r\n<br/>\r\n现已添加额外故事模式内容和功能齐全的照片模式。除此之外，Red Dead Redemption 2 玩家还可免费享受 Red Dead 在线模式中与众多玩家共享的逼真世界。此模式中，玩家可从事各种不同的职业，在边疆开拓属于自己的独特生涯。您可以成为追捕通缉犯的赏金猎人、经营自己生意的商贩、发掘珍奇宝藏的收藏家或运营地下酿酒厂的私酒贩等等。\r\n<br/>\r\nRed Dead Redemption 2 PC 版借助全新图形和技术改进以增强沉浸感，并充分利用了电脑强大的性能，使这个庞大、丰富而细致的世界的每个角落都栩栩如生。包括更广的渲染距离；为改良的昼夜照明而提供的更高质量的全局照明和环境光遮蔽；改良的反射和所有距离提供更深、更高分辨率的阴影；细分曲面处理树木纹理并改善草地和毛皮纹理，使所有植物和动物都更加逼真。\r\n<br/>\r\nRed Dead Redemption 2 PC 版还提供 HDR 支持，可在高端显示设置上以 4K 及更高分辨率运行、多显示器配置、宽屏配置、更快的帧速率及更多。', '荒野大镖客 救赎2', '动作，冒险'),
	(1245620, 'Elden Ring', 298.00, '\r\nFromSoftware Inc.', '\r\nFromSoftware Inc., Bandai Namco Entertainment', '2022-02-25', '・充满刺激的辽阔世界\r\n无缝连接的辽阔世界──尽情探索状况多变的开放场景，构造复杂、立体的巨大地下迷宫。\r\n在探索新发现时感到欣喜，在征服强敌时感到成就感十足，丰富内容等你体会。\r\n<br/>\r\n・专属于你的角色\r\n不只能自订操纵角色的外表，更能自行搭配武器、装备，与魔法──\r\n想成为力量取胜的顽强战士，或选择在魔法领域登峰造极，都能照自己的游玩风格决定。\r\n<br/>\r\n・源自神话的群像剧\r\n片段破碎，却又多彩的故事──以“交界地”为舞台登场的角色们各有主张，\r\n于是在利害关系之下谱成的群像剧，就此展开。\r\n<br/>\r\n・与其他玩家维持非即时连系的独特系统\r\n除了能与其他玩家一同游玩的多人联机游玩以外，\r\n本游戏也有非即时联机系统，能借此得知其他玩家的存在。', '艾尔登法环', '动作，角色扮演'),
	(1623730, 'Palworld', 108.00, '\r\nPocketpair', '\r\nPocketpair', '2024-01-19', 'Q. 这是一款怎样的游戏呢？\r\n<br/>\r\nA. 在帕鲁的世界，你可以选择与神奇的生物「帕鲁」一同享受悠闲的生活，也可以投身于与偷猎者进行生死搏斗的冒险。\r\n<br/>\r\n帕鲁可以进行战斗、繁殖、协助你做农活，也可以为你在工厂工作。\r\n你也可以将它们进行售卖，或肢解后食用。\r\n<br/>\r\n生存\r\n食物短缺、恶劣的环境……非法的偷猎者。这个世界危机四伏。为了生存你只能不择手段。有时候，你甚至要用帕鲁来充饥……\r\n<br/>\r\n骑乘、探索\r\n你可以骑着帕鲁去陆地、海洋、天空，在各种不同的场所进行探索。\r\n<br/>\r\n建造\r\n想建造金字塔吗？这时候就让大量的帕鲁为你做建造的工作吧。帕鲁并不受劳动法规的约束，尽请放心。\r\n<br/>\r\n生活\r\n生火、发电、采掘……。收集各种不同类型的便利帕鲁，来享受舒适的生活吧。\r\n<br/>\r\n农业\r\n不同的帕鲁擅长播种、浇水、收割等各类不同的工作。和帕鲁一起，打造美好的农园吧。\r\n<br/>\r\n\r\n工业、自动化\r\n为了实现自动化，将手工作业交给帕鲁就尤为重要。建造工厂，并安排帕鲁在其中工作吧。只要有足够的食物，帕鲁就可以不断地工作，直到它们生命的尽头。\r\n<br/>\r\n\r\n地下城探索\r\n有帕鲁在，哪怕危险的区域也大可放心。在危机时刻，你可以让帕鲁做你的替身。它们会不惜一切，哪怕舍弃自己的生命也会保护你。\r\n<br/>\r\n\r\n繁殖、遗传\r\n繁殖后，帕鲁将会继承父母的特性。将稀有的帕鲁组合在一起，繁育出最强的帕鲁吧！\r\n<br/>\r\n\r\n偷猎、犯罪\r\n在禁猎区栖息着濒临灭绝的稀有帕鲁。悄悄潜入那里并捕获它们你就能够大赚一笔！只要不被发现，就不算是犯罪。\r\n<br/>\r\n\r\n多人游戏\r\n支持多人游戏模式。邀请你的朋友一起来冒险吧！当然，你们也可以进行对战以及交易。', '幻兽帕鲁', '动作，冒险，独立，角色扮演'),
	(2358720, 'Black Myth: Wukong', 268.00, '\r\nGame Science', '\r\nGame Science', '2024-08-20', '《黑神话：悟空》是一款以中国神话为背景的动作角色扮演游戏。故事取材于中国古典小说“四大名著”之一的《西游记》。你将扮演一位“天命人”，为了探寻昔日传说的真相，踏上一条充满危险与惊奇的西游之路。\r\n<br/>\r\n• 雄奇壮丽，光怪陆离\r\n别有世间曾未见，一行一步一花新。欢迎来到亦真亦幻的东方魔幻世界！\r\n天命人将前往多个引人入胜又风格迥异的西游故地，再次谱写前所未见的冒险史诗。\r\n<br/>\r\n• 妖魔鬼怪，卷土重来\r\n行者名声大，魔王手段强。《西游记》的一大看点，便是各有所长的厉害妖怪。\r\n西行的旅途并非只有风光旖旎，天命人还将遭遇许多强大的敌人与可敬的对手，与他们豪快战斗，至死方休。\r\n<br/>\r\n• 山摇地动，各显神通\r\n炼就长生多少法，学来变化广无边。五光十色又相生相克的法术、变化与法宝，一直都是中国神话中最为招牌的战斗要素。\r\n天命人除了精通不同棍术，更可自由搭配多样化的法术、变化、天赋、武器与披挂，找到最契合自身战斗风格的制胜之道。\r\n<br/>\r\n• 千形万象，荡气回肠\r\n六般体相六般兵，六样形骸六样情。敌人的凶恶狡猾只是表象，他们的来历、个性与动机，往往更加耐人寻味。\r\n天命人在战斗之外，也会探寻各色人物背后的故事，了解他们的爱与恨，贪与嗔，前世与今生。', '黑神话：悟空', '动作，冒险，角色扮演'),
	(2420110, 'Horizon Forbidden West™', 414.00, '\r\nGuerrilla, Nixxes Software', '\r\nPlayStation Publishing LLC', '2024-03-21', '与埃洛伊同行，在危险壮美的边疆之地揭开种种未知的神秘威胁。此完整版可完整享受广受好评的《地平线 西之绝境™》内容和额外内容，包括在主线游戏后展开的后续故事“炙炎海岸”。\r\n<br/>\r\n重返《地平线》中遥远未来的后末日世界，探索远方的土地，对抗更庞大惊人的机器，认识奇异的新部族。\r\n<br/>\r\n大地濒临死亡。狂风暴雨，瘟疫肆虐，摧残着零星残存的人类，还有可怕的新机器在边境虎视眈眈。地球上的生命正急速冲向又一次大灭绝。\r\n<br/>\r\n这些威胁背后的谜团需要埃洛伊去寻找答案，以恢复世界的秩序和平衡。这趟旅程中，她不仅要和故友联手，还要和敌对的新派系结盟，揭开更多古老文明遗留的秘密。\r\n<br/>\r\n支持超宽分辨率21:9、终极超宽32:9以及48:9三显示器联放，使您不会错过任何游戏细节。*<br/>\r\n通过NVIDIA DLSS 3超级采样和帧生成、NVIDIA DLAA图像增强和NVIDIA Reflex延迟降低，您可以见证栩栩如生的《西之绝境》世界。本游戏还支持AMD FSR和Intel XeSS。**<br/>\r\n可根据喜好自定义图形设置，也可解锁帧率。**<br/>\r\n完全支持DualSense™控制器，包括触觉反馈和自适应扳机功能。***<br/>', '地平线 西之绝境™', '动作，角色扮演'),
	(100000001, 'Plants Vs Zombies', 5.00, '\r\nPopCap Games, Inc.', '\r\nPopCap Games, Inc., Electronic Arts', '2009-05-06', '来自曾开发过宝石迷阵和幻幻球的宝开公司的全新动作策略游戏！<br/>\r\n可怕的僵尸即将入侵你的家，唯一的防御方式就是你栽种的植物！武装你的植物，切换他们不同的功能，诸如强悍的豌豆射手或樱桃炸弹，更加快速有效的将僵尸阻挡在入侵的道路上。不同的敌人，不同的玩法构成五种不同的游戏模式，加之夕阳、浓雾以及泳池之类的障碍增加了其挑战性，奇特的游戏乐趣永无止境！<br/>\r\n独特的五种游戏模式：冒险，迷你，益智，生存，再加上毫无压力的禅境花园<br/>\r\n多达 50 个的冒险模式关卡设定，从白天到夜晚再到浓雾，从房顶到游泳池，场景变化多样<br/>\r\n游戏共有 26 种不同的僵尸敌人，包括撑杆僵尸，潜水僵尸和开着车子的雪橇车僵尸等，使游戏更具挑战性<br/>\r\n49 种功能强大，互不相同的植物，并可收集硬币购买宠物蜗牛，升级道具等多种道具！<br/>\r\n打开图鉴，可以看到植物与僵尸的详细介绍，再加上有趣的“事实”和引用<br/>\r\n通过“疯狂戴夫店”购买特殊植物和工具，以你能想象得到的方式干掉僵尸<br/>\r\n精致的游戏画面与声音，同时还更新有奖励型的音乐与视频<br/>\r\n无限次重玩：不会经历两次同样的事件！', '植物大战僵尸', '策略'),
	(100000002, 'Tower of the Sorcerer', 5.00, '史莱姆魔皇', '史莱姆魔皇', '2022-09-24', '前言：本作为本人怀旧系列第二作，基调仍然是最熟悉的感觉，最熟悉的记忆。<br/>\r\n其实吧，本来是只打算做50层的，但因为各种原因，翻了一倍……<br/>\r\n然后呢，原定是6月份完成的，中间因为各种破事也就拖到了现在了……<br/>\r\n至于后面还做不做魔塔，嗯看我本人还有没有那个精力去做吧……<br/>\r\n<br/>\r\n游戏快捷键说明：<br/>\r\n本作涉及的快捷键比上一作略多，<br/>\r\n按Esc/X/小键盘0键打开菜单，<br/>\r\nG键传送，Q键装备，<br/>\r\nN键打开地图显示伤害，<br/>\r\nZ键原地转向，<br/>\r\nI键查看留言簿信息，<br/>\r\nT键使用随意门，<br/>\r\nE键使用魔法冰块。<br/>\r\n<br/>\r\n关于负面状态：<br/>\r\n本作有四个负面状态：衰弱、中毒、冷冻、死气，<br/>\r\n另外由于改了显示机制因此是可！叠！加！的！<br/>\r\n衰弱：中此状态后，在下一次及以后的怪物战斗中扣减固定数额的攻防；<br/>\r\n中毒：中此状态后，所有的怪物在每回合都会对主角造成附加伤害；<br/>\r\n冷冻：同2018，中此状态后所有怪物先手攻击，<br/>\r\n死气：中此状态后，护盾失效（护盾为旧样板中所称的魔防）。<br/>\r\n状态药瓶对应颜色分别是紫红、绿、蓝、灰，另外，不能带走。<br/>\r\n<br/>\r\n关于结局：<br/>\r\n本作有四个明结局（相比前作少一个）。<br/><br/>\r\n其它：<br/>\r\n本作试着添加过撤回，以及更新一点的功能，但无一例外的失败了。<br/>\r\n另外为了路线问题本作不添加快捷商店。', '魔塔2023', '冒险，角色扮演，策略'),
	(100000009, '6744', 6.00, '5', '', '', '', '5', ''),
	(100000041, '4455554', 0.00, '', '', '', '', '', '');

-- 导出  表 game_db.game_comment 结构
CREATE TABLE IF NOT EXISTS `game_comment` (
  `cid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id，唯一标识评论对象',
  `uid` int unsigned DEFAULT NULL COMMENT '用户id',
  `gid` int unsigned DEFAULT NULL COMMENT '游戏id',
  `ctime` varchar(50) DEFAULT NULL,
  `comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `clike` int unsigned DEFAULT '0' COMMENT '评论赞数',
  `parent_cid` int unsigned DEFAULT NULL COMMENT '回复的目标评论的cid，即父评论cid',
  `parent_uid` int unsigned DEFAULT NULL COMMENT '回复贴的贴主uid',
  `del_flag` int unsigned DEFAULT '0' COMMENT '删除标记，0表示存在，2表示删除',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=266 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论表。\r\n内容是每个玩家对于每个游戏的评论。';

-- 正在导出表  game_db.game_comment 的数据：~19 rows (大约)
INSERT IGNORE INTO `game_comment` (`cid`, `uid`, `gid`, `ctime`, `comment`, `clike`, `parent_cid`, `parent_uid`, `del_flag`) VALUES
	(132, 109, 100000001, '2024-08-06 16:31:25', '沙发！', 2, NULL, NULL, 0),
	(134, 109, 100000001, '2024-08-06 16:33:12', '好游戏，盗了', 9, NULL, NULL, 0),
	(193, 114, 100000001, '2024-08-06 16:33:12', '你盗，哥们罩着你。小哥我是你社区黑老大', 1, 134, 109, 2),
	(194, 115, 100000001, '2024-08-08 13:22:47', '你6', 1, 193, 114, 0),
	(195, 115, 100000001, '2024-08-08 13:22:50', '卧槽，真的假的', 0, 194, 115, 2),
	(196, 115, 100000001, '2024-08-08 13:28:01', '6', 0, 134, 109, 0),
	(197, 115, 100000001, '2024-08-08 13:28:49', '你可以拿积分买，每个人都有积分。用不着盗。还要黑管理员服务器，多麻烦', 1, 134, 109, 0),
	(198, 109, 100000001, '2024-08-08 13:31:38', '能一样吗？我是盗卖，不是买着玩', 1, 197, 115, 0),
	(199, 115, 100000001, '2024-08-08 13:32:13', '6', 1, 198, 109, 0),
	(200, 114, 100000001, '2024-08-08 13:32:44', '6', 0, 198, 109, 0),
	(201, 114, 100000001, '2024-08-08 13:33:12', '哥们，你要真盗，麻烦偷偷说', 0, 198, 109, 0),
	(246, 1, 100000001, '2024-11-28 16:56:36', '首评！', 1, NULL, NULL, 0),
	(265, 1, 100000001, '2024-11-30 16:52:06', 'This is a comment.', 0, 196, 115, 0);

-- 导出  表 game_db.game_comment2 结构
CREATE TABLE IF NOT EXISTS `game_comment2` (
  `cid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id，唯一标识评论对象',
  `uid` int unsigned DEFAULT NULL COMMENT '用户id',
  `gid` int unsigned DEFAULT NULL COMMENT '游戏id',
  `uname` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ctime` varchar(50) DEFAULT NULL,
  `comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `clike` int unsigned DEFAULT '0' COMMENT '评论赞数',
  `cparentid` int unsigned DEFAULT NULL COMMENT '回复的目标评论的cid，即父评论cid',
  `cpath` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '用于评论区评论排序的序列',
  `del_flag` int unsigned DEFAULT '0' COMMENT '删除标记，0表示存在，2表示删除',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论表。\r\n内容是每个玩家对于每个游戏的评论。';

-- 正在导出表  game_db.game_comment2 的数据：~40 rows (大约)
INSERT IGNORE INTO `game_comment2` (`cid`, `uid`, `gid`, `uname`, `ctime`, `comment`, `clike`, `cparentid`, `cpath`, `del_flag`) VALUES
	(132, 109, 100000001, '121天堂先生', '2024-08-06 16:31:25', '沙发！', 2, NULL, '99997[2024-08-06 16:31:25]', 0),
	(134, 109, 100000001, '121天堂先生', '2024-08-06 16:33:12', '好游戏，盗了', 9, NULL, '99991[2024-08-06 16:33:12]', 0),
	(193, 114, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;121天堂先生', NULL, '此评论已删除', 0, NULL, '99991[2024-08-06 16:33:12]#[2024-08-08 13:01:34]', 2),
	(194, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-08 13:22:47', '3', 1, 193, '99991[2024-08-06 16:33:12]#[2024-08-08 13:01:34]#[2024-08-08 13:01:37]#[2024-08-08 13:22:47]', 0),
	(195, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-08 13:22:50', '4', 0, 194, '99991[2024-08-06 16:33:12]#[2024-08-08 13:01:34]#[2024-08-08 13:01:37]#[2024-08-08 13:22:47]#[2024-08-08 13:22:50]', 0),
	(196, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;121天堂先生', '2024-08-08 13:28:01', '6', 1, 134, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:01]', 0),
	(197, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;121天堂先生', '2024-08-08 13:28:49', '你可以拿积分买，每个人都有积分。用不着盗。还要黑管理员服务器，多麻烦', 1, 134, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]', 0),
	(198, 109, 100000001, '121天堂先生&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-08 13:31:38', '能一样吗？我是盗卖，不是买着玩', 0, 197, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]', 0),
	(199, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;121天堂先生', '2024-08-08 13:32:13', '6', 0, 198, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:32:13]', 0),
	(200, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;121天堂先生', '2024-08-08 13:32:44', '6', 1, 198, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:32:44]', 0),
	(201, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;121天堂先生', '2024-08-08 13:33:12', '哥们，你要真盗，麻烦偷偷说', 0, 198, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]', 0),
	(202, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:34:26', '人管理员也不好做', 0, 201, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]#[2024-08-08 13:34:26]', 0),
	(203, 114, 100000001, '188小菩提', '2024-08-08 13:38:05', '游戏不错，支持。希望勤更。', 3, NULL, '99996[2024-08-08 13:38:05]', 0),
	(204, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:38:48', '内容有点简单，希望多加点单体防御高的僵尸。', 1, 203, '99999[2024-08-08 13:38:05]#[2024-08-08 13:38:48]', 0),
	(210, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:42:58', '唉', 0, 202, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]#[2024-08-08 13:34:26]#[2024-08-08 13:42:58]', 0),
	(211, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:43:54', '不容易', 0, 202, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]#[2024-08-08 13:34:26]#[2024-08-08 13:43:54]', 0),
	(212, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:44:01', '不容易', 0, 211, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]#[2024-08-08 13:34:26]#[2024-08-08 13:43:54]#[2024-08-08 13:44:01]', 0),
	(213, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:45:42', '1', 0, 211, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]#[2024-08-08 13:34:26]#[2024-08-08 13:43:54]#[2024-08-08 13:45:42]', 0),
	(214, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:50:29', '2', 0, 213, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]#[2024-08-08 13:34:26]#[2024-08-08 13:43:54]#[2024-08-08 13:45:42]#[2024-08-08 13:50:29]', 0),
	(215, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 13:50:45', '啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦', 0, 214, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:49]#[2024-08-08 13:31:38]#[2024-08-08 13:33:12]#[2024-08-08 13:34:26]#[2024-08-08 13:43:54]#[2024-08-08 13:45:42]#[2024-08-08 13:50:29]#[2024-08-08 13:50:45]', 0),
	(216, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-08 14:06:17', '6', 0, 196, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:01]#[2024-08-08 14:06:17]', 0),
	(217, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 14:07:02', '6', 0, 216, '99991[2024-08-06 16:33:12]#[2024-08-08 13:28:01]#[2024-08-08 14:06:17]#[2024-08-08 14:07:02]', 0),
	(218, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;121天堂先生', '2024-08-08 14:08:07', '6', 0, 132, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]', 0),
	(219, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 14:08:09', '6', 0, 218, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]#[2024-08-08 14:08:09]', 0),
	(220, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 14:08:11', '6', 0, 219, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]#[2024-08-08 14:08:09]#[2024-08-08 14:08:11]', 0),
	(221, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 14:08:15', '6', 0, 220, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]#[2024-08-08 14:08:09]#[2024-08-08 14:08:11]#[2024-08-08 14:08:15]', 0),
	(222, 114, 100000001, '188小菩提&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-08 14:08:18', '6', 0, 221, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]#[2024-08-08 14:08:09]#[2024-08-08 14:08:11]#[2024-08-08 14:08:15]#[2024-08-08 14:08:18]', 0),
	(223, 114, 100000001, '188小菩提', '2024-08-08 14:09:04', '6', 1, NULL, '99998[2024-08-08 14:09:04]', 0),
	(225, 115, 2420110, '196个小天使', '2024-08-09 09:04:20', 'sofa！', 1, NULL, '99998[2024-08-09 09:04:20]', 0),
	(226, 115, 100000002, '196个小天使', '2024-08-09 10:41:46', '新增小猪loading.html作为页面加载动画。', 1, NULL, '99998[2024-08-09 10:41:46]', 0),
	(227, 115, 100000002, '196个小天使', '2024-08-09 10:43:15', '修改了index.jsp的html布局（但几乎未改变其视图），使其更符合逻辑和易读。', 0, NULL, '99999[2024-08-09 10:43:15]', 0),
	(228, 115, 100000002, '196个小天使', '2024-08-09 10:52:47', '美化了game-not-found页。', 0, NULL, '99999[2024-08-09 10:52:47]', 0),
	(232, 115, 100000001, '196个小天使', '2024-08-09 14:18:21', 'test', 1, NULL, '99998[2024-08-09 14:18:21]', 0),
	(233, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-09 14:18:28', 'test_reply', 0, 232, '99999[2024-08-09 14:18:21]#[2024-08-09 14:18:28]', 0),
	(234, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-09 14:18:36', 'test_reply2', 0, 233, '99999[2024-08-09 14:18:21]#[2024-08-09 14:18:28]#[2024-08-09 14:18:36]', 0),
	(235, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;188小菩提', '2024-08-11 09:13:06', '这个地方会不再阶梯式顺延，而是平齐缩进。', 0, 222, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]#[2024-08-08 14:08:09]#[2024-08-08 14:08:11]#[2024-08-08 14:08:15]#[2024-08-08 14:08:18]#[2024-08-11 09:13:06]', 0),
	(236, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-11 09:13:38', '是因为最大单位缩进量是4.', 0, 235, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]#[2024-08-08 14:08:09]#[2024-08-08 14:08:11]#[2024-08-08 14:08:15]#[2024-08-08 14:08:18]#[2024-08-11 09:13:06]#[2024-08-11 09:13:38]', 0),
	(237, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-11 09:14:06', '所以第5条评论及以后都会平齐', 0, 236, '99997[2024-08-06 16:31:25]#[2024-08-08 14:08:07]#[2024-08-08 14:08:09]#[2024-08-08 14:08:11]#[2024-08-08 14:08:15]#[2024-08-08 14:08:18]#[2024-08-11 09:13:06]#[2024-08-11 09:13:38]#[2024-08-11 09:14:06]', 0),
	(238, 115, 100000001, '196个小天使', '2024-08-23 22:18:29', 'd', 0, NULL, '99999[2024-08-23 22:18:29]', 0),
	(239, 115, 100000001, '196个小天使&nbsp;&nbsp;回复&nbsp;&nbsp;196个小天使', '2024-08-23 22:18:32', 'd', 0, 238, '99999[2024-08-23 22:18:29]#[2024-08-23 22:18:32]', 0);

-- 导出  表 game_db.game_comment_like 结构
CREATE TABLE IF NOT EXISTS `game_comment_like` (
  `uid` int NOT NULL,
  `gid` int DEFAULT NULL,
  `cid` int NOT NULL,
  PRIMARY KEY (`cid`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='记录用户和评论之间的点赞关系的表';

-- 正在导出表  game_db.game_comment_like 的数据：~15 rows (大约)
INSERT IGNORE INTO `game_comment_like` (`uid`, `gid`, `cid`) VALUES
	(1, 100000001, 132),
	(1, 100000001, 134),
	(1, 100000001, 193),
	(1, 100000001, 194),
	(1, 100000001, 197),
	(1, 100000001, 198),
	(1, 100000001, 199),
	(1, 100000001, 204),
	(1, 100000001, 246),
	(1, 100000001, 249),
	(1, 100000001, 250),
	(1, 100000001, 251),
	(1, 100000001, 261),
	(1, 100000001, 264);

-- 导出  表 game_db.game_like 结构
CREATE TABLE IF NOT EXISTS `game_like` (
  `uid` int NOT NULL,
  `gid` int NOT NULL,
  PRIMARY KEY (`uid`,`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='记录用户-游戏是否具有点赞状态的关系的表';

-- 正在导出表  game_db.game_like 的数据：~6 rows (大约)
INSERT IGNORE INTO `game_like` (`uid`, `gid`) VALUES
	(1, 1245620),
	(1, 1623730),
	(1, 2420110),
	(1, 100000001),
	(1, 100000002);

-- 导出  表 game_db.order 结构
CREATE TABLE IF NOT EXISTS `order` (
  `onumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '订单编号',
  `uid` int NOT NULL COMMENT '用户id',
  `gid` int NOT NULL COMMENT '游戏id',
  `otime` datetime DEFAULT NULL COMMENT '订单生成时间',
  PRIMARY KEY (`onumber`),
  KEY `FK_order_game` (`gid`),
  KEY `FK_order_user` (`uid`),
  CONSTRAINT `FK_order_game` FOREIGN KEY (`gid`) REFERENCES `game` (`gid`),
  CONSTRAINT `FK_order_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- 正在导出表  game_db.order 的数据：~1 rows (大约)
INSERT IGNORE INTO `order` (`onumber`, `uid`, `gid`, `otime`) VALUES
	('656187238798852096', 1, 100000001, '2024-11-17 10:57:27');

-- 导出  表 game_db.role_permission 结构
CREATE TABLE IF NOT EXISTS `role_permission` (
  `role_id` int DEFAULT NULL COMMENT '角色外键',
  `permission_id` int DEFAULT NULL COMMENT '权限外键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色-权限关系表';

-- 正在导出表  game_db.role_permission 的数据：~19 rows (大约)
INSERT IGNORE INTO `role_permission` (`role_id`, `permission_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 8),
	(1, 9),
	(1, 10),
	(1, 11),
	(1, 12),
	(2, 1),
	(2, 2),
	(2, 3),
	(2, 4),
	(2, 5),
	(2, 6);

-- 导出  表 game_db.sys_permission 结构
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '请求地址',
  `parent_id` int DEFAULT NULL COMMENT '父权限主键',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限类型， M - 菜单， A - 子菜单， U - 普通请求',
  `permit` varchar(128) DEFAULT NULL COMMENT '权限字符串描述，如：user:list 用户查看权限；   user 用户权限；   user:insert 用户新增权限 等',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';

-- 正在导出表  game_db.sys_permission 的数据：~12 rows (大约)
INSERT IGNORE INTO `sys_permission` (`id`, `name`, `url`, `parent_id`, `type`, `permit`, `remark`) VALUES
	(1, '登录', '/login', 0, 'U', 'login:login', '登录权限'),
	(2, '进入登录页面', '/login', 0, 'U', 'login:toLogin', '进入登录权限'),
	(3, '登出', '/logout', 0, 'U', 'logout', '登出权限'),
	(4, '注册', '/register', 0, 'U', 'reg:register', '注册权限'),
	(5, '进入注册页面', '/toRegister', 0, 'U', 'reg:toRegister', '进入注册页面权限'),
	(6, '用户管理', '', 0, 'M', 'user:manager', '用户管理权限'),
	(7, '用户查询', '/user/list', 6, 'A', 'user:list', '用户查询权限'),
	(8, '用户新增', '/user/add', 6, 'U', 'user:add', '用户新增权限'),
	(9, '进入用户新增页面', '/user/toAdd', 6, 'U', 'user:toAdd', '进入用户新增页面权限'),
	(10, '用户修改', '/user/modify', 6, 'U', 'user:modify', '用户修改权限'),
	(11, '进入用户修改页面', '/user/toModify', 6, 'U', 'user:toModify', '进入用户修改页面权限'),
	(12, '用户删除', '/user/remove', 6, 'U', 'user:remove', '用户删除权限');

-- 导出  表 game_db.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

-- 正在导出表  game_db.sys_role 的数据：~2 rows (大约)
INSERT IGNORE INTO `sys_role` (`id`, `name`, `remark`) VALUES
	(1, 'ADMIN', '超级管理员（全部权限）'),
	(2, 'USER', '普通用户（基础权限）');

-- 导出  表 game_db.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '懒惰的用户' COMMENT '用户名',
  `utel` char(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话号码',
  `uemail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `urole` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'user' COMMENT '用户或管理员',
  `ugender` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '保密' COMMENT '性别',
  `uaddress` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '保密' COMMENT '住址',
  `upsw` varchar(100) NOT NULL COMMENT '密码（MD5加密后）',
  `upoint` float DEFAULT NULL COMMENT '用户积分',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `utel` (`utel`),
  UNIQUE KEY `uemail` (`uemail`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- 正在导出表  game_db.user 的数据：~5 rows (大约)
INSERT IGNORE INTO `user` (`uid`, `uname`, `utel`, `uemail`, `urole`, `ugender`, `uaddress`, `upsw`, `upoint`) VALUES
	(1, 'root', 'root', '12283726693@163.com', 'admin', '男', '河南省信阳市', '$2a$04$UtK4DHwHmMcPo30pKbmxIeVjGuYKUpV.Q4tvbN39bV9A4clp6OENK', 25),
	(2, '2号密码为12345678的女士。啊啦啊啦呦呦呦，名字太长了呀，这可为难码农了吧，bulabula', '12345678901', 'zhangjing@139.com', 'vip', '女', '上海市浦东新区', '$2a$04$Yks0YwbGrD92jOdDgZeAuebeUGuKvScJnpctM83QyAlXhNoQmjm3.', 60),
	(109, '109号121天堂先生', '12121212121', '12121212121@tel.com', 'user', '保密', '121之家', '$2a$04$zURcxFNPk1zw8KlVtGF7vOkcMMJYmNbZGcAXx.3eadJCKl1pcAKZa', 394),
	(114, '114号小菩提的188倍率', '10000000188', '10000000188@163.com', 'user', '保密', '天堂', '$2a$04$86AN/m8qKCLrcpFuKMTLUuZUGwwhlrts4MqIPWnjkvwHvHF3OXgIq', 20),
	(115, '115号196个小天使', '10000000196', '10000000196@163.com', 'user', '男', '天堂', '$2a$04$ffGoT1lLpOgaib1rozKyhOKjbUEJB99LJpqbFU669cRfpe8Vblzca', 94);

-- 导出  表 game_db.user_role 结构
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int NOT NULL COMMENT '用户外键',
  `role_id` int DEFAULT NULL COMMENT '角色外键',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户-角色关系表';

-- 正在导出表  game_db.user_role 的数据：~2 rows (大约)
INSERT IGNORE INTO `user_role` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
