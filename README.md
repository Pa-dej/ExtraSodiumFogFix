# 🌫️ ExtraSodiumFogFix / Фикс ванильного тумана

## 📜 Description / Описание

**English**  
This mod ensures that fog in Minecraft remains **fair and vanilla-like**, even when using optimization mods like [Sodium Extra](https://modrinth.com/mod/sodium-extra).  
Many mods offer useful fog customization for visuals or performance, but some of those changes (like removing fog entirely) can **give players unfair advantages** in multiplayer.  
ExtraSodiumFogFix lets players **keep their favorite mods**, while **blocking only the fog tweaks that could break balance** — like seeing through water, lava, or long distances.

✅ No hard dependency on Sodium or Sodium Extra  
✅ Works with any mod that touches fog — by applying a mixin with **priority 1400**  
✅ Keeps the game fair and honest without banning whole mods

---

**Русский**  
Этот мод обеспечивает, чтобы туман в Minecraft оставался **честным и ванильным**, даже если используются моды вроде [Sodium Extra](https://modrinth.com/mod/sodium-extra).  
Многие моды позволяют настраивать туман для красоты или производительности, но иногда такие настройки (например, полное отключение тумана) могут **давать игрокам преимущество** в мультиплеере.  
ExtraSodiumFogFix позволяет игрокам **использовать свои любимые моды**, но **отменяет только те изменения тумана, которые нарушают баланс** — например, полную прозрачность воды, лавы или снега.

✅ Нет жёсткой зависимости от Sodium / Sodium Extra  
✅ Работает с любыми модами, влияющими на туман — через mixin с **приоритетом 1400**  
✅ Сохраняет честность игры без запрета полезных модов

---

## 🖼 До / После (Before / After)

<p align="center">
  <img src="https://cdn.modrinth.com/data/1seZ4ZH4/images/5b22241e58969551a0cc93a3b1fc3a66dab2037c.png" alt="Сравнение: до и после" width="720"/>
</p>

<p align="center">
  <i>Слева — тумана нет (с настройками модификатора), справа — честный ванильный туман (с этим модом)</i><br/>
  <i>Left: fog removed (via mod config), Right: restored vanilla fog (with this mod)</i>
</p>

---

## ⚙️ Совместимость / Compatibility

- ✅ Fabric и Quilt
- ✅ Работает как с Sodium Extra, так и без него
- ✅ Нет зависимостей
- 🚫 Не запрещает модификацию тумана полностью — только **нейтрализует нечестные настройки**
- 🧠 Приоритет миксина `@Mixin(priority = 1400)` перебивает другие вмешательства (например, Sodium Extra с `1300`)

---

## 📦 Установка / Installation

1. Установите Fabric или Quilt Loader
2. Скачайте `.jar` этого мода
3. Поместите файл в папку `mods`
4. Готово — туман снова как в ваниле, но с поддержкой других визуальных модов

---

## 💬 Почему это важно? / Why does it matter?

Иногда моды ради производительности или красоты делают туман **слишком прозрачным**, из-за чего:
- Игроки видят дальше, чем должны
- Могут замечать структуры сквозь воду или снег
- Получают нечестное PvP-преимущество

Мод **не ломает моды**, а лишь **восстанавливает баланс**, позволяя использовать кастомные настройки, не нарушая честность игры.
