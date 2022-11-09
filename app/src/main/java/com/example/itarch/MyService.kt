package com.example.itarch

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {
    override fun onCreate(){
        super.onCreate()
    }
    override fun onBind(intent : Intent): IBinder {
        return binder
    }
    val TAG = "Service"
    val NametoURL = mapOf<String, String>(
        "サイラッハ" to "https://arknights.wikiru.jp/attach2/A5B5A5A4A5E9A5C3A5CF_7361696C656163685F7472696D2E706E67.png",
        "サガ" to "https://arknights.wikiru.jp/attach2/A5B5A5AC_536167615F7472696D2E706E67.png",
        "シージ" to "https://arknights.wikiru.jp/attach2/A5B7A1BCA5B8_A5B7A1BCA5B82E706E67.png",
        "バグパイプ" to "https://arknights.wikiru.jp/attach2/A5D0A5B0A5D1A5A4A5D7_A5D0A5B0A5D1A5A4A5D72E706E67.png",
        "フレイムテイル" to "https://arknights.wikiru.jp/attach2/A5D5A5ECA5A4A5E0A5C6A5A4A5EB_466C616D657461696C2E706E67.png",
        "アイリーニ" to "https://arknights.wikiru.jp/attach2/A5A2A5A4A5EAA1BCA5CB_6972656E652E706E67.png",
        "シルバーアッシュ" to "https://arknights.wikiru.jp/attach2/A5B7A5EBA5D0A1BCA5A2A5C3A5B7A5E5_A5B7A5EBA5D0A1BCA5A2A5C3A5B7A5E52E706E67.png",
        "スカジ" to "https://arknights.wikiru.jp/attach2/A5B9A5ABA5B8_A5B9A5ABA5C7A5A32E706E67.png",
        "スルト" to "https://arknights.wikiru.jp/attach2/A5B9A5EBA5C8_737572745F395F31362E706E67.png",
        "ソーンズ" to "https://arknights.wikiru.jp/attach2/A5BDA1BCA5F3A5BA_A5BDA1BCA5F3A5BAB0B5BDCC2E706E67.png",
        "チェン" to "https://arknights.wikiru.jp/attach2/A5C1A5A7A5F3_A5C1A5A7A5F32E706E67.png",
        "パラス" to "https://arknights.wikiru.jp/attach2/A5D1A5E9A5B9_50616C6C61732E706E67.png",
        "ブレイズ" to "https://arknights.wikiru.jp/attach2/A5D6A5ECA5A4A5BA_A5D6A5ECA5A4A5BA2E706E67.png",
        "ヘラグ" to "https://arknights.wikiru.jp/attach2/A5D8A5E9A5B0_A5D8A5E9A5AC2E706E67.png",
        "マウンテン" to "https://arknights.wikiru.jp/attach2/A5D8A5E9A5B0_A5D8A5E9A5AC2E706E67.png",
        "耀騎士ニアール" to "https://arknights.wikiru.jp/attach2/CDD4B5B3BBCEA5CBA5A2A1BCA5EB_4E6561726C54686552616469616E744B6E696768745F742E706E67.png",
        "サリア" to "https://arknights.wikiru.jp/attach2/A5B5A5EAA5A2_A5B5A5EAA5A22E706E67.png",
        "ニェン" to "https://arknights.wikiru.jp/attach2/A5CBA5A7A5F3_6E69616E2E706E67.png",
        "ブレミシャイン" to "https://arknights.wikiru.jp/attach2/A5D6A5ECA5DFA5B7A5E3A5A4A5F3_626C656D697368696E652E706E67.png",
        "ホシグマ" to "https://arknights.wikiru.jp/attach2/A5DBA5B7A5B0A5DE_A5DBA5B7A5B0A5DE2E706E67.png",
        "ホルン" to "https://arknights.wikiru.jp/attach2/A5DBA5EBA5F3_686F726E2E706E67.png",
        "マドロック" to "https://arknights.wikiru.jp/attach2/A5DEA5C9A5EDA5C3A5AF_6D7564726F636B5F2E706E67.png",
        "ユーネクテス" to "https://arknights.wikiru.jp/attach2/A5E6A1BCA5CDA5AFA5C6A5B9_A5E6A1BCA5CDA5AFA5C6A5B95FB0B5BDCC2E706E67.png",
        "Ash" to "https://arknights.wikiru.jp/attach2/417368_A5A2A5C3A5B7A5E52E706E67.png",
        "W" to " https://arknights.wikiru.jp/attach2/5728A5D7A5ECA5A4A5A2A5D6A5EB29_572E706E67.png",
        "アルケット" to "https://arknights.wikiru.jp/attach2/A5A2A5EBA5B1A5C3A5C8_617263686574746F2E706E67.png",
        "エクシア" to "https://arknights.wikiru.jp/attach2/A5A8A5AFA5B7A5A2_A5A8A5AFA5B7A5A2312E706E67.png",
        "シュヴァルツ" to "https://arknights.wikiru.jp/attach2/A5B7A5E5A5F4A5A1A5EBA5C4_7363687761727A2E706E67.png",
        "ファートゥース" to "https://arknights.wikiru.jp/attach2/A5D5A5A1A1BCA5C8A5A5A1BCA5B9_466172746F6F74682E706E67.png",
        "フィアメッタ" to "https://arknights.wikiru.jp/attach2/A5D5A5A3A5A2A5E1A5C3A5BF_6669616D6D657474615F7472696D2E706E67.png",
        "ロサ" to "https://arknights.wikiru.jp/attach2/A5EDA5B5_A5EDA5B55FB0B5BDCC2E706E67.png",
        "ロスモンティス" to "https://arknights.wikiru.jp/attach2/A5EDA5B9A5E2A5F3A5C6A5A3A5B9_A5EDA5B9A5E2A5F3A5C6A5A3A5B92E706E67.png",
        "遊龍チェン" to "https://arknights.wikiru.jp/attach2/CDB7CEB6A5C1A5A7A5F3_4368656E546865486F6C756E676461792E706E67.png",
        "イフリータ" to "https://arknights.wikiru.jp/attach2/A5A4A5D5A5EAA1BCA5BF_636861725F3133345F69667269745F315F526573697A652E706E67.png",
        "エイヤフィヤトラ" to "https://arknights.wikiru.jp/attach2/A5A8A5A4A5E4A5D5A5A3A5E4A5C8A5E9_A5A8A5A4A5E4A5D5A5A3A5E4A5C8A5E92E706E67.png",
        "カーネリアン" to "https://arknights.wikiru.jp/attach2/A5ABA1BCA5CDA5EAA5A2A5F3_4361726E656C69616E2E706E67.png",
        "ケオベ" to "https://arknights.wikiru.jp/attach2/A5B1A5AAA5D9_63656F62652E706E67.png",
        "ゴールデングロー" to "https://arknights.wikiru.jp/attach2/A5B4A1BCA5EBA5C7A5F3A5B0A5EDA1BC_476F6C64656E676C6F772E706E67.png",
        "シー" to "https://arknights.wikiru.jp/attach2/A5B7A1BC_4475736B5F7472696D2E706E67.png",
        "パッセンジャー" to "https://arknights.wikiru.jp/attach2/A5D1A5C3A5BBA5F3A5B8A5E3A1BC_70617373656E6765725F7472696D2E706E67.png",
        "モスティマ" to "https://arknights.wikiru.jp/attach2/A5E2A5B9A5C6A5A3A5DE_A5E2A5B9A5C6A5A3A5DE2E706E67.png",
        "ケルシー" to "https://arknights.wikiru.jp/attach2/A5B1A5EBA5B7A1BC_6B616C27747369742E706E67.png",
        "シャイニング" to "https://arknights.wikiru.jp/attach2/A5B7A5E3A5A4A5CBA5F3A5B0_A5B7A5E3A5A4A5CBA5F3A5B02E706E67.png,",
        "ナイチンゲール" to "https://arknights.wikiru.jp/attach2/A5CAA5A4A5C1A5F3A5B2A1BCA5EB_A5CAA5A4A5C1A5F3A5B2A1BCA5EB2E706E67.png",
        "ルーメン" to "https://arknights.wikiru.jp/attach2/A5EBA1BCA5E1A5F3_6C756D656E2E706E67.png",
        "アンジェリーナ" to "https://arknights.wikiru.jp/attach2/A5A2A5F3A5B8A5A7A5EAA1BCA5CA_A5A2A5F3A5B8A5A7A5EAA1BCA5CA2E706E67.png",
        "スズラン" to "https://arknights.wikiru.jp/attach2/A5B9A5BAA5E9A5F3_A5B9A5BAA5E9A5F35FB0B5BDCC2E706E67.png",
        "ノーシス" to "https://arknights.wikiru.jp/attach2/A5CEA1BCA5B7A5B9_476E6F7369732E706E67.png",
        "マゼラン" to "https://arknights.wikiru.jp/attach2/A5DEA5BCA5E9A5F3_A5DEA5BCA5E9A5F32E706E67.png",
        "リィン" to "https://arknights.wikiru.jp/attach2/A5EAA5A3A5F3_4C696E675F742E706E67.png",
        "濁心スカジ" to "https://arknights.wikiru.jp/attach2/C2F9BFB4A5B9A5ABA5B8_C2F9BFB4A5B9A5ABA5B82E706E67.png",
        "ア" to "https://arknights.wikiru.jp/attach2/A5A2_A5A25FCEA9B3A82E706E67.png",
        "ウィーディ" to "https://arknights.wikiru.jp/attach2/A5A6A5A3A1BCA5C7A5A3_A5A6A5A3A1BCA5C7A5A32E706E67.png",
        "グレイディーア" to "https://arknights.wikiru.jp/attach2/A5B0A5ECA5A4A5C7A5A3A1BCA5A2_476C6164696961322E706E67.png",
        "ファントム" to "https://arknights.wikiru.jp/attach2/A5D5A5A1A5F3A5C8A5E0_A5D5A5A1A5F3A5C8A5E02E706E67.png",
        "ミヅキ" to "https://arknights.wikiru.jp/attach2/A5DFA5C5A5AD_4D697A756B692E706E67.png",
        "リー" to "https://arknights.wikiru.jp/attach2/A5EAA1BC_4C65652E706E67.png",
        "帰溟スペクター" to "https://arknights.wikiru.jp/attach2/B5A2DEF2A5B9A5DAA5AFA5BFA1BC_73706563746572322E706E67.png",
    )
    val NametoPosition = mapOf<String, String>(
        "サイラッハ" to "先鋒",
        "サガ" to "先鋒",
        "シージ" to "先鋒",
        "バグパイプ" to "先鋒",
        "フレイムテイル" to "先鋒",
        "アイリーニ" to "前衛",
        "シルバーアッシュ" to "前衛",
        "スカジ" to "前衛",
        "スルト" to "前衛",
        "ソーンズ" to "前衛",
        "チェン" to "前衛",
        "パラス" to "前衛",
        "ブレイズ" to "前衛",
        "ヘラグ" to "前衛",
        "マウンテン" to "前衛",
        "耀騎士ニアール" to "前衛",
        "サリア" to "重装",
        "ニェン" to "重装",
        "ブレミシャイン" to "重装",
        "ホシグマ" to "重装",
        "ホルン" to "重装",
        "マドロック" to "重装",
        "ユーネクテス" to "重装",
        "Ash" to "狙撃",
        "W" to "狙撃",
        "アルケット" to "狙撃",
        "エクシア" to "狙撃",
        "シュヴァルツ" to "狙撃",
        "ファートゥース" to "狙撃",
        "フィアメッタ" to "狙撃",
        "ロサ" to "狙撃",
        "ロスモンティス" to "狙撃",
        "遊龍チェン" to "狙撃",
        "イフリータ" to "術師",
        "エイヤフィヤトラ" to "術師",
        "カーネリアン" to "術師",
        "ケオベ" to "術師",
        "ゴールデングロー" to "術師",
        "シー" to "術師",
        "パッセンジャー" to "術師",
        "モスティマ" to "術師",
        "ケルシー" to "医療",
        "シャイニング" to "医療",
        "ナイチンゲール" to "医療",
        "ルーメン" to "医療",
        "アンジェリーナ" to "補助",
        "スズラン" to "補助",
        "ノーシス" to "補助",
        "マゼラン" to "補助",
        "リィン" to "補助",
        "濁心スカジ" to "補助",
        "ア" to "特殊",
        "ウィーディ" to "特殊",
        "グレイディーア" to "特殊",
        "ファントム" to "特殊",
        "ミヅキ" to "特殊",
        "リー" to "特殊",
        "帰溟スペクター" to "特殊",
    )

    private val binder = object : IMyAidlInterface.Stub() {
        override fun getURL(operatorName: String): String {
            if (NametoURL[operatorName] != null) {
                return NametoURL[operatorName]!!
            } else {
                return ""
            }
        }
        override fun getPosition(operatorName: String): String {
            if(NametoPosition[operatorName] != null) {
                return NametoPosition[operatorName]!!
            } else {
                return ""
            }
        }
    }
}
