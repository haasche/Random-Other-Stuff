--UI fixes
local f = CreateFrame("Frame", nil, UIParent)
f:RegisterEvent("PLAYER_LOGIN")
f:SetScript("OnEvent", function(self, event)

  -- stuff to do on login goes after here
  UIParent:SetScale(0.62)
  MicroButtonAndBagsBar:Hide(1)
  -- stuff to do on login goes before here

  f:UnregisterAllEvents()
end)

local U=UnitIsUnit hooksecurefunc("CompactUnitFrame_UpdateName",function(F)
if IsActiveBattlefieldArena() and F.unit:find("nameplate")
  then 
  for i=1,5 
  do 
    if U(F.unit,"arena"..i)
      then F.name:SetText(i)F.name:SetTextColor(1,1,0)
break end end end end)
