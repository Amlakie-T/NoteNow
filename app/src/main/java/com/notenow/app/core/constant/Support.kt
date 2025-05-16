package com.notenow.app.core.constant

import android.content.Context
import com.notenow.app.R

object SupportConst {
    /**
     * Address of eth account
     */
    const val ETHERIUM_ADDRESS = "0x55da346403d0c33575c863a7bf763fb0be97e421"

    /**
     * Address of bnb account
     */
    const val BNB_SMART_ADDRESS = "0x55da346403d0c33575c863a7bf763fb0be97e421"

    /**
     * Address of tron account
     */
    const val TRON_ADDRESS = "TDXQa2PF5sYAXwVav2XEbVCSaHkiN1AJAS"

    /**
     * Address of bitcoin account
     */
    const val BITCOIN_ADDRESS = "1Kw7k6hAdbaE2zLck9ztyJTMfjSysVqkQ8"

    /**
     * Address of polygon account

    const val POLYGON_ADDRESS = "0x05D8aC16B2d4C07958E2430d24F7F55d51238C6e"
     */

    /**
     * Address of avalanche account
    const val AVALANCHE_ADDRESS = "0x05D8aC16B2d4C07958E2430d24F7F55d51238C6e"
    */

    /**
     * Address of avalanche account

    const val MONERO_ADDRESS = "45G7Eg5uXaLNb55ykor43aTx2iztYfUAkCT677LiKEuGAcq3AjLdUZnNkt9bGbeAm35Ye2PayYgPsdNH4Tfw8Qx2GSF3nww"
     */
    const val TERMS_EFFECTIVE_DATE = "2025/05/16"

    /**
     * Provides a map of supporters categorized by their roles using localized strings.
     */
    fun getSupportersMap(context: Context): Map<String, List<String>> {
        return mapOf(
            context.getString(R.string.donators) to listOf("Amlakie-T"),
            context.getString(R.string.contributors) to listOf("Shishkevichd", "Lenni-builder", "IllusionMan1212", "wadeack"),
            context.getString(R.string.translators) to listOf("searinminecraft", "Loco1911", "Maell1", "kuragehimekurara1", "Crazy-Unicooorn", "rickdtc", "Mikropsoft", "NicKoehler", "Koamedev", "Oersen", "DRIVER", "wzry2580", "ersen", "DragibusNoir", "TamarindoJuice")
        )
    }
}