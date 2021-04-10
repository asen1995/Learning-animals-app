package com.asennikolaev.learninganimals.model;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.utils.Language;

import java.util.HashMap;
import java.util.Map;

public class ImageResources {

    protected static Map<Integer,String> imageAnswerMap;

    private static Language languageApp = Language.SPANISH;

    public static void initImages() {

        imageAnswerMap  = new HashMap<>();

        switch (languageApp){
            case ENGLISH: {
                initEnglishWord();
                break;
            }
            case SPANISH: {
                initSpanishWords();
                break;
            }

        }
    }

    private static void initSpanishWords() {


        //SPANISH

        imageAnswerMap.put(R.drawable.bunny, "conejita");
        imageAnswerMap.put(R.drawable.deer, "ciervo");
        imageAnswerMap.put(R.drawable.fox, "zorro");
        imageAnswerMap.put(R.drawable.wolf, "lobo");
        imageAnswerMap.put(R.drawable.camel, "camello");
        imageAnswerMap.put(R.drawable.shark, "tiburón");
        imageAnswerMap.put(R.drawable.frog, "rana");
        imageAnswerMap.put(R.drawable.dolphin, "delfín");
        imageAnswerMap.put(R.drawable.beaver, "castor");
        imageAnswerMap.put(R.drawable.hedgehog, "erizo");
        imageAnswerMap.put(R.drawable.cat, "gata");
        imageAnswerMap.put(R.drawable.dog, "perro");
        imageAnswerMap.put(R.drawable.iguana, "iguana");
        imageAnswerMap.put(R.drawable.walrus, "morsa");
        imageAnswerMap.put(R.drawable.owl, "búho");
        imageAnswerMap.put(R.drawable.bee, "abeja");
        imageAnswerMap.put(R.drawable.ant, "hormiga");
        imageAnswerMap.put(R.drawable.butterfly, "mariposa");
        imageAnswerMap.put(R.drawable.kangaroo, "canguro");
        imageAnswerMap.put(R.drawable.elephant, "elefante");
        imageAnswerMap.put(R.drawable.bear, "oso");
        imageAnswerMap.put(R.drawable.penguin, "Pingüino");
        imageAnswerMap.put(R.drawable.rhino, "rinoceronte");
        imageAnswerMap.put(R.drawable.lion, "león");
        imageAnswerMap.put(R.drawable.tiger, "tigre");
        imageAnswerMap.put(R.drawable.crocodile, "cocodrilo");
        imageAnswerMap.put(R.drawable.turtle, "tortuga");
        imageAnswerMap.put(R.drawable.chameleon, "camaleón");
        imageAnswerMap.put(R.drawable.swan, "cisne");
        imageAnswerMap.put(R.drawable.pelican, "pelícano");
        imageAnswerMap.put(R.drawable.panda, "panda");
        imageAnswerMap.put(R.drawable.ostrich, "avestruz");
        imageAnswerMap.put(R.drawable.parrot, "loro");
        imageAnswerMap.put(R.drawable.horse, "caballo");
        imageAnswerMap.put(R.drawable.bison, "bisonte");
        imageAnswerMap.put(R.drawable.eagle, "Águila");
        imageAnswerMap.put(R.drawable.hyena, "hiena");
        imageAnswerMap.put(R.drawable.badger, "tejón");
        imageAnswerMap.put(R.drawable.zebra, "cebra");
        imageAnswerMap.put(R.drawable.giraffe, "jirafa");
        imageAnswerMap.put(R.drawable.hippopotamus, "hipopótamo");
        imageAnswerMap.put(R.drawable.chimpanzee, "chimpancé");
        imageAnswerMap.put(R.drawable.gorilla, "gorila");
        imageAnswerMap.put(R.drawable.mammoth, "mamut");
        imageAnswerMap.put(R.drawable.flamingo, "flamenco");
        imageAnswerMap.put(R.drawable.koala, "coala");
        imageAnswerMap.put(R.drawable.platypus, "ornitorrinco");
        imageAnswerMap.put(R.drawable.python, "pitón");
        imageAnswerMap.put(R.drawable.balloonfish, "pez globo");
        imageAnswerMap.put(R.drawable.bat, "murciélago");
        imageAnswerMap.put(R.drawable.jellyfish, "Medusa");
        imageAnswerMap.put(R.drawable.woodpecker, "pájaro carpintero");
        imageAnswerMap.put(R.drawable.stork, "cigüeña");
        imageAnswerMap.put(R.drawable.cuckoo, "cuco");
        imageAnswerMap.put(R.drawable.goose, "ganso");
        imageAnswerMap.put(R.drawable.sparrow, "gorrión");
        imageAnswerMap.put(R.drawable.pheasant, "Faisán");
        imageAnswerMap.put(R.drawable.lizard, "lagarto");
        imageAnswerMap.put(R.drawable.octopus, "pulpo");
        imageAnswerMap.put(R.drawable.anteater, "oso hormiguero");


    }

    private static void initEnglishWord() {

        imageAnswerMap.put(R.drawable.bunny, "bunny");
        imageAnswerMap.put(R.drawable.deer, "deer");
        imageAnswerMap.put(R.drawable.fox, "fox");
        imageAnswerMap.put(R.drawable.wolf, "wolf");
        imageAnswerMap.put(R.drawable.camel, "camel");
        imageAnswerMap.put(R.drawable.shark, "shark");
        imageAnswerMap.put(R.drawable.frog, "frog");
        imageAnswerMap.put(R.drawable.dolphin, "dolphin");
        imageAnswerMap.put(R.drawable.beaver, "beaver");
        imageAnswerMap.put(R.drawable.hedgehog, "hedgehog");
        imageAnswerMap.put(R.drawable.cat, "cat");
        imageAnswerMap.put(R.drawable.dog, "dog");
        imageAnswerMap.put(R.drawable.iguana, "iguana");
        imageAnswerMap.put(R.drawable.walrus, "walrus");
        imageAnswerMap.put(R.drawable.owl, "owl");
        imageAnswerMap.put(R.drawable.bee, "bee");
        imageAnswerMap.put(R.drawable.ant, "ant");
        imageAnswerMap.put(R.drawable.butterfly, "butterfly");
        imageAnswerMap.put(R.drawable.kangaroo, "kangaroo");
        imageAnswerMap.put(R.drawable.elephant, "elephant");
        imageAnswerMap.put(R.drawable.bear, "bear");
        imageAnswerMap.put(R.drawable.penguin, "penguin");
        imageAnswerMap.put(R.drawable.rhino, "rhino");
        imageAnswerMap.put(R.drawable.lion, "lion");
        imageAnswerMap.put(R.drawable.tiger, "tiger");
        imageAnswerMap.put(R.drawable.crocodile, "crocodile");
        imageAnswerMap.put(R.drawable.turtle, "turtle");
        imageAnswerMap.put(R.drawable.chameleon, "chameleon");
        imageAnswerMap.put(R.drawable.swan, "swan");
        imageAnswerMap.put(R.drawable.pelican, "pelican");
        imageAnswerMap.put(R.drawable.panda, "panda");
        imageAnswerMap.put(R.drawable.ostrich, "ostrich");
        imageAnswerMap.put(R.drawable.parrot, "parrot");
        imageAnswerMap.put(R.drawable.horse, "horse");
        imageAnswerMap.put(R.drawable.bison, "bison");
        imageAnswerMap.put(R.drawable.eagle, "eagle");
        imageAnswerMap.put(R.drawable.hyena, "hyena");
        imageAnswerMap.put(R.drawable.badger, "badger");
        imageAnswerMap.put(R.drawable.zebra, "zebra");
        imageAnswerMap.put(R.drawable.giraffe, "giraffe");
        imageAnswerMap.put(R.drawable.hippopotamus, "hippopotamus");
        imageAnswerMap.put(R.drawable.chimpanzee, "chimpanzee");
        imageAnswerMap.put(R.drawable.gorilla, "gorilla");
        imageAnswerMap.put(R.drawable.mammoth, "mammoth");
        imageAnswerMap.put(R.drawable.flamingo, "flamingo");
        imageAnswerMap.put(R.drawable.koala, "koala");
        imageAnswerMap.put(R.drawable.platypus, "platypus");
        imageAnswerMap.put(R.drawable.python, "python");
        imageAnswerMap.put(R.drawable.balloonfish, "balloon fish");
        imageAnswerMap.put(R.drawable.bat, "bat");
        imageAnswerMap.put(R.drawable.jellyfish, "jellyfish");
        imageAnswerMap.put(R.drawable.woodpecker, "woodpecker");
        imageAnswerMap.put(R.drawable.stork, "stork");
        imageAnswerMap.put(R.drawable.cuckoo, "cuckoo");
        imageAnswerMap.put(R.drawable.goose, "goose");
        imageAnswerMap.put(R.drawable.sparrow, "sparrow");
        imageAnswerMap.put(R.drawable.pheasant, "pheasant");
        imageAnswerMap.put(R.drawable.lizard, "lizard");
        imageAnswerMap.put(R.drawable.octopus, "octopus");
        imageAnswerMap.put(R.drawable.anteater, "anteater");

    }
}
