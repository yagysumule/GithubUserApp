package com.yagysumule.githubusers.utils

import java.util.*
import com.yagysumule.githubusers.data.source.local.entity.UserEntity

object DataDummy {

    fun generateDummyUsers(): List<UserEntity> {

        val users = ArrayList<UserEntity>()

        users.add(
            UserEntity(
                "JakeWharton",
                "Jake Wharton",
                "@drawable/user1",
                "Google, Inc.",
                "Pittsburgh, PA, USA",
                102,
                56995,
                12,
                false
            )
        )
        users.add(
            UserEntity(
                "amitshekhariitbhu",
                "AMIT SHEKHAR",
                "@drawable/user2",
                "@MindOrksOpenSource",
                "New Delhi, India",
                37,
                5153,
                2,
                false
            )
        )
        users.add(
            UserEntity(
                "romainguy",
                "Romain Guy",
                "@drawable/user3",
                "Google",
                "California",
                9,
                7972,
                0,
                false
            )
        )
        users.add(
            UserEntity(
                "chrisbanes",
                "Chris Banes",
                "@drawable/user4",
                "@google working on @android",
                "Sydney, Australia",
                30,
                14725,
                1,
                false
            )
        )
        users.add(
            UserEntity(
                "tipsy",
                "David",
                "@drawable/user5",
                "Working Group Two",
                "Trondheim, Norway",
                56,
                788,
                0,
                false
            )
        )
        users.add(
            UserEntity(
                "ravi8x",
                "Ravi Tamada",
                "@drawable/user6",
                "AndroidHive | Droid5",
                "India",
                28,
                18628,
                3,
                false
            )
        )
        users.add(
            UserEntity(
                "jasoet",
                "Deny Prasetyo",
                "@drawable/user7",
                "@gojek-engineering",
                "Kotagede, Yogyakarta, Indonesia",
                44,
                277,
                39,
                false
            )
        )
        users.add(
            UserEntity(
                "budioktaviyan",
                "Budi Oktaviyan",
                "@drawable/user8",
                "@KotlinID",
                "Jakarta, Indonesia",
                110,
                178,
                23,
                false
            )
        )
        users.add(
            UserEntity(
                "hendisantika",
                "Hendi Santika",
                "@drawable/user9",
                "@JVMDeveloperID @KotlinID @IDDevOps",
                "Bojongsoang - Bandung Jawa Barat",
                1064,
                428,
                61,
                false
            )
        )
        users.add(
            UserEntity(
                "sidiqpermana",
                "Sidiq Permana",
                "@drawable/user10",
                "Nusantara Beta Studio",
                "Jakarta Indonesia",
                65,
                465,
                10,
                false
            )
        )

        return users
    }
}