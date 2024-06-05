package com.example.cvmaroc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;


public class adsActivity extends AppCompatActivity {
    public static final String PREF_FILE= "MyPref";
    public static final String PURCHASE_KEY= "purchase";
    public static final String PRODUCT_ID= "purchase";

    TextView purchaseStatus;
    Button purchaseButton;
//    private BillingClient billingClient;






    LinearLayout pagehome, pageads, pagelanges, sharepage, aboutpage;

    private DuoDrawerLayout duoDrawerLayout;
    private Button openmenudrawer;

    private LinearLayout closemenuduo;
    CardView mycardview;
    View mainContentview;
    ImageView googlePayButton;
    EditText amountEditText;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.ads_page);
/*
        purchaseStatus=(TextView) findViewById(R.id.purchase_status);
        purchaseButton=(Button) findViewById(R.id.purchase_button);

        // Establish connection to billing client
        //check purchase status from google play store cache
        //to check if item already Purchased previously or refunded
        billingClient = BillingClient.newBuilder(this)
                .enablePendingPurchases().setListener((PurchasesUpdatedListener) this).build();
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                if(billingResult.getResponseCode()==BillingClient.BillingResponseCode.OK){
                    Purchase.PurchasesResult queryPurchase = billingClient.queryPurchases(INAPP);
                    List<Purchase> queryPurchases = queryPurchase.getPurchasesList();
                    if(queryPurchases!=null && queryPurchases.size()>0){
                        handlePurchases(queryPurchases);
                    }
                    //if purchase list is empty that means item is not purchased
                    //Or purchase is refunded or canceled
                    else{
                        savePurchaseValueToPref(false);
                    }
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
            }
        });

        //item Purchased
        if(getPurchaseValueFromPref()){
            purchaseButton.setVisibility(View.GONE);
            purchaseStatus.setText("Purchase Status : Purchased");
        }
        //item not Purchased
        else{
            purchaseButton.setVisibility(View.VISIBLE);
            purchaseStatus.setText("Purchase Status : Not Purchased");
        }*/
        duoDrawerLayout = findViewById(R.id.drawer_layout);
        openmenudrawer = findViewById(R.id.menu);

        mycardview = findViewById(R.id.mainContentCardView);
        closemenuduo = findViewById(R.id.btnclose_menu);
        mainContentview = findViewById(R.id.mainContentView);
        pagehome = findViewById(R.id.homepage);
        pagelanges = findViewById(R.id.traslatepage);
        pageads = findViewById(R.id.remouveads);
        sharepage = findViewById(R.id.share);
        aboutpage  = findViewById(R.id.info);
        // Set OnClickListener for open_menu ImageView
        openmenudrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the DuoMenuView
                duoDrawerLayout.openDrawer();
            }
        });
// Set up DuoDrawerToggle to handle drawer open/close events
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this, duoDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        duoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();

        // Set up listener for drawer open/close events
        duoDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Slide offset is from 0 to 1, indicating the position of the drawer



                // Adjust the scale of the main content view
                float scale = 1 - 0.1f * slideOffset; // Adjust the scale factor as needed
                mainContentview.setScaleX(scale);
                mainContentview.setScaleY(scale);


                // Adjust the corner radius based on the slide offset

                float cornerRadius = slideOffset * getResources().getDimensionPixelSize(R.dimen.max_corner_radius);
                mycardview.setRadius(cornerRadius);
            }
        });
        closemenuduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                duoDrawerLayout.closeDrawer();
            }
        });


        pagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adsActivity.this, mycvActivity.class);
                startActivity(intent);            }
        });

        pageads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duoDrawerLayout.closeDrawer();
            }
        });
        pagelanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adsActivity.this, langue_Activity.class);
                startActivity(intent);         }
        });

        sharepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adsActivity.this, ShareActivity.class);
                startActivity(intent);
            }
        });

        aboutpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }
    /*private SharedPreferences getPreferenceObject() {
        return getApplicationContext().getSharedPreferences(PREF_FILE, 0);
    }
    private SharedPreferences.Editor getPreferenceEditObject() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(PREF_FILE, 0);
        return pref.edit();
    }
    private boolean getPurchaseValueFromPref(){
        return getPreferenceObject().getBoolean( PURCHASE_KEY,false);
    }
    private void savePurchaseValueToPref(boolean value){
        getPreferenceEditObject().putBoolean(PURCHASE_KEY,value).commit();
    }

    //initiate purchase on button click
    public void purchase(View view) {
        //check if service is already connected
        if (billingClient.isReady()) {
            initiatePurchase();
        }
        //else reconnect service
        else{
            billingClient = BillingClient.newBuilder(this).enablePendingPurchases().setListener((PurchasesUpdatedListener) this).build();
            billingClient.startConnection(new BillingClientStateListener() {
                @Override
                public void onBillingSetupFinished(BillingResult billingResult) {
                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        initiatePurchase();
                    } else {
                        Toast.makeText(getApplicationContext(),"Error "+billingResult.getDebugMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onBillingServiceDisconnected() {
                }
            });
        }
    }
    private void initiatePurchase() {
        List<String> skuList = new ArrayList<>();
        skuList.add(PRODUCT_ID);
        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
        params.setSkusList(skuList).setType(INAPP);
        billingClient.querySkuDetailsAsync(params.build(),
                new SkuDetailsResponseListener() {
                    @Override
                    public void onSkuDetailsResponse(BillingResult billingResult,
                                                     List<SkuDetails> skuDetailsList) {
                        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                            if (skuDetailsList != null && skuDetailsList.size() > 0) {
                                BillingFlowParams flowParams = BillingFlowParams.newBuilder()
                                        .setSkuDetails(skuDetailsList.get(0))
                                        .build();
                                billingClient.launchBillingFlow(adsActivity.this, flowParams);
                            }
                            else{
                                //try to add item/product id "purchase" inside managed product in google play console
                                Toast.makeText(getApplicationContext(),"Purchase Item not Found",Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    " Error "+billingResult.getDebugMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> purchases) {
        //if item newly purchased
        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && purchases != null) {
            handlePurchases(purchases);
        }
        //if item already purchased then check and reflect changes
        else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
            Purchase.PurchasesResult queryAlreadyPurchasesResult = billingClient.queryPurchases(INAPP);
            List<Purchase> alreadyPurchases = queryAlreadyPurchasesResult.getPurchasesList();
            if(alreadyPurchases!=null){
                handlePurchases(alreadyPurchases);
            }
        }
        //if purchase cancelled
        else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
            Toast.makeText(getApplicationContext(),"Purchase Canceled",Toast.LENGTH_SHORT).show();
        }
        // Handle any other error msgs
        else {
            Toast.makeText(getApplicationContext(),"Error "+billingResult.getDebugMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    void handlePurchases(List<Purchase>  purchases) {
        for(Purchase purchase:purchases) {
            //if item is purchased
            if (PRODUCT_ID.equals(purchase.getSku()) && purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED)
            {
                if (!verifyValidSignature(purchase.getOriginalJson(), purchase.getSignature())) {
                    // Invalid purchase
                    // show error to user
                    Toast.makeText(getApplicationContext(), "Error : Invalid Purchase", Toast.LENGTH_SHORT).show();
                    return;
                }
                // else purchase is valid
                //if item is purchased and not acknowledged
                if (!purchase.isAcknowledged()) {
                    AcknowledgePurchaseParams acknowledgePurchaseParams =
                            AcknowledgePurchaseParams.newBuilder()
                                    .setPurchaseToken(purchase.getPurchaseToken())
                                    .build();
                    billingClient.acknowledgePurchase(acknowledgePurchaseParams, ackPurchase);
                }
                //else item is purchased and also acknowledged
                else {
                    // Grant entitlement to the user on item purchase
                    // restart activity
                    if(!getPurchaseValueFromPref()){
                        savePurchaseValueToPref(true);
                        Toast.makeText(getApplicationContext(), "Item Purchased", Toast.LENGTH_SHORT).show();
                        this.recreate();
                    }
                }
            }
            //if purchase is pending
            else if( PRODUCT_ID.equals(purchase.getSku()) && purchase.getPurchaseState() == Purchase.PurchaseState.PENDING)
            {
                Toast.makeText(getApplicationContext(),
                        "Purchase is Pending. Please complete Transaction", Toast.LENGTH_SHORT).show();
            }
            //if purchase is unknown
            else if(PRODUCT_ID.equals(purchase.getSku()) && purchase.getPurchaseState() == Purchase.PurchaseState.UNSPECIFIED_STATE)
            {
                savePurchaseValueToPref(false);
                purchaseStatus.setText("Purchase Status : Not Purchased");
                purchaseButton.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "Purchase Status Unknown", Toast.LENGTH_SHORT).show();
            }
        }
    }
    AcknowledgePurchaseResponseListener ackPurchase = new AcknowledgePurchaseResponseListener() {
        @Override
        public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
            if(billingResult.getResponseCode()==BillingClient.BillingResponseCode.OK){
                //if purchase is acknowledged
                // Grant entitlement to the user. and restart activity
                savePurchaseValueToPref(true);
                Toast.makeText(getApplicationContext(), "Item Purchased", Toast.LENGTH_SHORT).show();
                adsActivity.this.recreate();
            }
        }
    };

    /**
     * Verifies that the purchase was signed correctly for this developer's public key.
     * <p>Note: It's strongly recommended to perform such check on your backend since hackers can
     * replace this method with "constant true" if they decompile/rebuild your app.
     * </p>
     */
   /* public boolean verifyValidSignature(String signedData, String signature) {
        try {
            // To get key go to Developer Console > Select your app > Development Tools > Services & APIs.
            String base64Key = "Add Your Key Here";
            return Security.verifyPurchase(base64Key, signedData, signature);
        } catch (IOException e) {
            return false;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(billingClient!=null){
            billingClient.endConnection();
        }
    }*/


}






