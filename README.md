# MPAndroidChart Demo

## Priprava

V `settings.gradle.kts` dodamo
```
repositories {
        maven {
            url = uri("https://jitpack.io")
        }
    }
```
V `build.gradle.kts` (Module :app)
```
dependencies {
    implementation('com.github.PhilJay:MPAndroidChart:v3.1.0')
}
```

## Grafi


## Utemeljitev izbire
Grafe sem hotel dodati 2. aplikaciji pri vajah PORA.

## Prednosti

## Slabosti

## Ostali osnovni podatki
### Licenca
Copyright: ©Philipp Jahoda

Pod licenco [**Apache License, Version 2.0**](https://www.apache.org/licenses/LICENSE-2.0)


### Št. uporabnikov
Glede na 38.000 zvezdic na GitHubu je sam projekt precej popularen in bi ga lahko uporabljalo 
nekje pol milijona razvijalcev/projektov.

Drugi podatki pravtako kažejo uporabo v več kot 10.000 Android aplikacijah s skupno miljardami
prenosov.

### Časovna zahtevnost
Delo z grafom z `n` točkami ima zahtevnost `O(n)` pri:
 - izrisovanju
 - skaliranju
 - formatiranju podatkov
 - posodobitvi točk

### Prostorska zahtevnost
Podobno kot pri času, `O(n)` glede na število točk, ki jih graf uporablja.

### Vzdrževanje
Nazadnje posodobljeno pred pol leta. K projektu prispevalo 68 ljudi.