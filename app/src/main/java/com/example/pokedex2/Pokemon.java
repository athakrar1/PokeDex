package com.example.pokedex2;

import android.content.Context;

import java.util.ArrayList;

public class Pokemon {
    Context context;
    static ArrayList<Pokemon> pokemonArray = new ArrayList<Pokemon>();

    String Name;
    int Hash;
    int Attack;
    int Defense;
    String FlavorText;
    int HP;
    int SpAttack;
    int SpDef;
    int Speed;
    int Total;
    ArrayList<String> Type;

    public Pokemon(String name, int hash, int attack, int defense, String flavorText, int hp, int spAttack,
                   int spDef, int speed, int total, ArrayList<String> type){
        this.Name = name;
        this.Hash = hash;
        this.Attack = attack;
        this.Defense = defense;
        this.FlavorText = flavorText;
        this.HP = hp;
        this.SpAttack = spAttack;
        this.SpDef = spDef;
        this.Speed = speed;
        this.Total = total;
        this.Type = type;
    }
}
