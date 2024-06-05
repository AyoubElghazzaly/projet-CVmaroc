plugins {
    id("com.android.application")

}

android {
    namespace = "com.example.cvmaroc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cvmaroc"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.wdullaer:materialdatetimepicker:4.2.3")

    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")

    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.makeramen:roundedimageview:2.3.0")

    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("com.itextpdf:itext7-core:7.1.15")
    implementation ("com.android.billingclient:billing:3.0.1")

    implementation("nl.psdcompany:duo-navigation-drawer:3.0.0")
    implementation ("com.google.android.gms:play-services-ads:22.6.0")

}
